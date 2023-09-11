<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    Boolean isPopup = false;
    String top_loc = "customer";
%>
<%@ include file="/WEB-INF/views/top.jsp" %>
<%@ include file="/WEB-INF/views/left.jsp" %>
<div class="main_wrap" style="overflow-x:auto">
    <script>
        /*
        grid data 페이징용 세팅
         */
        var setCustCd = "";
        var gridRowNum = 50;
        var gridDataType = "local";
        const searchResultColNames =  [
            "번호",
            "거래처코드",
            "거래처명1",
            "거래처명2",
            "거래처구분",
            "거래처유형",
            "사업자번호",
            "대표자명",
            "업태",
            "업종",
            "주소",
            "SAP벤더코드",
            "SAP고객코드",
            "등록자",
            "등록일시",
            "수정자",
            "수정일시"
        ];
        const searchResultColModel =  [
            {name:'rownum',  index:'rownum',  align:'center'},
            {name:'CustCd',  index:'CustCd',  align:'center'},
            {name:'CustName1',    index:'CustName1',    align:'left', width:'220px'},
            {name:'CustName2',    index:'CustName2',    align:'left', width:'220px'},
            {name:'CustGuName',  index:'CustGuName',  align:'center'},
            {name:'CustGu', index:'CustGu', align:'center'},
            {name:'BizNo', index:'BizNo', align:'center'},
            {name:'RepName', index:'RepName', align:'center'},
            {name:'CompType', index:'CompType', align:'center'},
            {name:'CompKind', index:'CompKind', align:'CompKind'},
            {name:'Addrs', index:'Addrs', align:'center',width:'300px'},
            {name:'ERPVendorCd', index:'ERPVendorCd', align:'center'},
            {name:'ERPCustCd', index:'ERPCustCd', align:'center'},
            {name:'RegiUser', index:'RegiUser', align:'center'},
            {name:'RegiDate', index:'RegiDate', align:'center', width:'350px'},
            {name:'ModifyUser', index:'ModifyUser', align:'center'},
            {name:'ModifyDate', index:'ModifyDate', align:'center', width:'350px'}

        ];

        const searchResultColNames2 =  [
            "회사",
            "가상계좌",
            "계좌복사",
            "가상계좌번호",
            "은행",
            "예금주",
            "계좌번호",
            "지급조건",
            "코드",
            "회사유형"
        ];
        const searchResultColModel2 =  [
            {name:'CompCdName',  index:'CompCdName',  align:'center', width:'200px'},
            {name:'VrAcntYn',  index:'VrAcntYn',  align:'center',  editable:true, edittype:'checkbox', editoptions:{name:'VrAcntYn', value:'Y:N'}},
            {name:'VrAcntCopyYn',    index:'VrAcntCopyYn',    align:'center', width:'220px', editable:true, edittype:'checkbox', editoptions:{name:'VrAcntCopyYn', value:'Y:N'}},
            {name:'VrAcntNo',    index:'VrAcntNo',    align:'left', width:'220px', editable:false},
            {name:'CmBankName',  index:'CmBankName',  align:'center', width:'250px', editable:true, edittype:'select', editoptions:{dataUrl:'/customer/CMP0100301SBankOption?codeDiv=020&companyID=000001', buildSelect:setSelectCombo}},
            {name:'SaverName', index:'SaverName', align:'center', editable:true, edittype:'text', editoptions: {size:20, maxlength:'255'}},
            {name:'AcntNo', index:'AcntNo', align:'center', editable:true, edittype:'text', editoptions: {size:20, maxlength:'255'}},
            {name:'CmPayTermName', index:'CmPayTermName', align:'center', width:'250px', editable:true, edittype:'select', editoptions:{dataUrl:'/customer/CMP0100301STermOption?codeDiv=083&companyID=000001', buildSelect:setSelectCombo2}},
            {name:'CustCd', index:'CustCd', align:'center', width:'40px'},
            {name:'CompCd', index:'CompCd', align:'center', width:'40px'}
        ];

        var gridPage = 1;
        var gridPager = "#gridPager";
        var gridWrapper = "mainGrid2";
        var gridWrapper2 = "gridAccount";
        var selectedCustCd = "";

        const $j = jQuery;
        var jqGridSet = null;
        let myData = [];
        let myData2 = [];
        const gridTitle = "검색결과 ";
        let gridMsg = "&nbsp; TOTAL : <span id='gridTotal'>0건</span>";

        jQuery(function() {

            //메인 그리드
            jQuery("#"+gridWrapper).jqGrid({
                colNames: searchResultColNames,
                colModel: searchResultColModel,
                rowNum : gridRowNum,
                height: 400,
                width: 1300,
                caption : gridTitle + gridMsg,
                pager : gridPager,
                onSelectRow : function(rowId, status, e) {
                    var selData = $('#'+gridWrapper).jqGrid('getRowData', rowId);
                    selectedCustCd = selData.CustCd;
                    console.log(selData);
                    Search_cust(selData.CustCd);
                    $("#SAP_RECIVE").val("");
                }
            });

            jQuery('#searchGridBtn').click(() => {
                //새로운 조회조건으로 조회시 입력폼 초기화..
                if($("#C_CustName1" ).val() == '' && $("#C_BizNo" ).val() == '' && $("#C_CmCustTypeCd" ).val() == '' && $("#C_CustCd" ).val() == '' && $("#C_CustGu" ).val() == '' && $("#C_SapYn" ).val() == '' && $("#C_RepName" ).val() == '')
                {
                    alert('검색조건을 한가지 이상 필수로 선택하셔야 합니다.');
                    return false;
                }
                searchGrid();
            });
            var gridLastSel2;
            //계좌 그리드
            jQuery("#"+gridWrapper2).jqGrid({
                colNames: searchResultColNames2,
                colModel: searchResultColModel2,
                rowNum : gridRowNum,
                height: 160,
                width: 890,
                onSelectRow: function(id) {
                    $("#"+gridWrapper2).jqGrid("resetSelection");
                }
            });
            $("#"+gridWrapper2).jqGrid("hideCol",["CustCd","CompCd"]);

            Search_new();
        });

        function New() {

            $("#CustCd").val("");
            $("#CustName1").val("");
            $("#CustName2").val("");
            $("#CustGu").val("002");
            //changeCustGu("002");

            $("#BizNo").val("");
            $("#h_BizNo").val("");
            $("#RepName").val("");
            $("#CompType").val("");
            $("#CompKind").val("");
            $("#Addr").val("");
            $("#ERPVendorCd").val("");
            $("#ERPCustCd").val("");
            $("#CorpNo").val("");
            $("#PersonNo").val("");
            $("#h_PersonNo").val("");
            $("#TelNo").val("");
            $("#FaxNo").val("");
            $("#ZipNo").val("");
            $("#ZipAddr").val("");
            $("#EmailAddr").val("");
            $("#RecvName").val("");
            $("#Desc").val("");
            $("#UseYN").val("Y");
            $("#VrCopyCustCd").val("");
            $("#VrCopyCustCdHidn").val("");

            $("#CmCustTypeCd").val("");
            $("#"+gridWrapper2).jqGrid("resetSelection");
            $("#"+gridWrapper2).jqGrid("clearGridData");

            Search_new();//기본 회사코드 조회해서 뿌려줌
        }

        /**
         * 실제 그리드 검색
         */
        function searchGrid() {
            New();
            gridLoader(true);
            $("#searchGridBtn2").jqGrid("clearGridData");

            const C_CustCd = jQuery('#C_CustCd').val();
            const gridPage = jQuery('#gridPage').val();
            const C_CustName1 = jQuery('#C_CustName1').val();
            const C_BizNo = String(jQuery('#C_BizNo').val()).replace(/[^0-9]/gi,'');
            const C_CustGu = jQuery('#C_CustGu').val();
            const C_CmCustTypeCd = jQuery('#C_CmCustTypeCd').val();
            const C_SapYn = jQuery('#C_SapYn').val();

            jQuery.post('/customer/customerSearch', {
                C_CustCd:C_CustCd,
                gridPage:gridPage,
                C_CustName1:C_CustName1,
                C_BizNo:C_BizNo,
                C_CustGu:C_CustGu,
                C_CmCustTypeCd:C_CmCustTypeCd,
                C_SapYn:C_SapYn,
                gridRowNum:gridRowNum
            }).done( function(data2) {
                myData = [];
                const realData = jQuery.parseJSON(data2);
                if(realData.success === 'Y') {
                    if(realData.data.length > 0) {
                        myData = realData.data;
                    } else {
                        myData = [];
                        alert('검색 결과가 없습니다.');
                        gridLoader(false);
                    }
                } else {
                    myData = [];
                    alert('처리할 수 없습니다.');
                    gridLoader(false);
                }
                setGridData2();
            });

        }

        function setGridData2() {
            if(myData.length < 1) {
                $('#'+gridWrapper).jqGrid('clearGridData', true);
            } else {
                selectedCustCd = myData[0]['CustCd'];
                $('#'+gridWrapper).jqGrid('clearGridData', true);
                jQuery("#"+gridWrapper).jqGrid('setGridParam',

                    {
                        datatype: 'local',
                        data:myData
                    })

                    .trigger("reloadGrid");

                $("#"+gridWrapper). jqGrid('setSelection', "1", true); //row 선택하기
            }

            //gridMsg = "&nbsp; TOTAL : " + myData.length;
            jQuery('#gridTotal').text(numberWithCommas(myData.length)+'건');
            gridLoader(false);
        }

        function Search_cust(C_CustCd) {

            jQuery.post('/customer/CMP010104S', {
                C_CustCd : C_CustCd
            }, function(data2) {
                console.log(data2);
                var result = jQuery.parseJSON(data2);
                if(result.success === 'Y') {
                    if(result.data.length > 0) {
                        var dat = result.data[0];
                        $("#CustCd"           ).val(dat.CustCd);
                        $("#CustName1"        ).val(dat.CustName1);
                        $("#CustName2"        ).val(dat.CustName2);
                        $("#BizNo"            ).val(dat.BizNo);
                        $("#h_BizNo"          ).val(dat.h_BizNo);
                        $("#RepName"          ).val(dat.RepName);
                        $("#CompType"         ).val(dat.CompType);
                        $("#CompKind"         ).val(dat.CompKind);
                        $("#Addr"             ).val(dat.Addr);
                        $("#ERPVendorCd"      ).val(dat.ERPVendorCd);
                        $("#ERPCustCd"        ).val(dat.ERPCustCd);
                        $("#CorpNo"           ).val(dat.CorpNo);
                        $("#PersonNo"         ).val(dat.PersonNo);
                        $("#h_PersonNo"       ).val(dat.h_PersonNo);
                        $("#TelNo"            ).val(dat.TelNo);
                        $("#FaxNo"            ).val(dat.FaxNo);
                        $("#ZipNo"            ).val(dat.ZipNo);
                        $("#ZipAddr"          ).val(dat.ZipAddr);
                        $("#EmailAddr"        ).val(dat.EmailAddr);
                        $("#RecvName"         ).val(dat.RecvName);
                        $("#Desc"             ).val(dat.Desc);
                        $("#UseYN"            ).val(dat.UseYN);
                        $("#CustGu"           ).val(dat.CustGu);
                        $("#VrCopyCustCdHidn" ).val(dat.VrCopyCustCdHidn);
                        $("#VrCopyCustCd"     ).val(dat.VrCopyCustCd);
                        $("#CmCustTypeCd"     ).val(dat.CmCustTypeCd);

                        Search2(C_CustCd);
                    }
                } else {
                    $("#"+gridWrapper).jqGrid("resetSelection");
                }
            });
            /*
                        var rowCount = table.getCount();
                        if (rowCount > 0) {
                            $("#CustCd"           ).val(table.getData(0,0));
                            $("#CustName1"        ).val(table.getData(1,0));
                            $("#CustName2"        ).val(table.getData(2,0));
                            //CustGuName : table.getData(3,0));
                            $("#BizNo"            ).val(table.getData(4,0));
                            $("#h_BizNo"          ).val(table.getData(4,0));
                            $("#RepName"          ).val(table.getData(5,0));
                            $("#CompType"         ).val(table.getData(6,0));
                            $("#CompKind"         ).val(table.getData(7,0));
                            $("#Addr"             ).val(table.getData(8,0));
                            $("#ERPVendorCd"      ).val(table.getData(9,0));
                            $("#ERPCustCd"        ).val(table.getData(10,0));

                            $("#CorpNo"           ).val(table.getData(15,0));
                            $("#PersonNo"         ).val(table.getData(16,0));
                            $("#h_PersonNo"       ).val(table.getData(16,0));
                            $("#TelNo"            ).val(table.getData(17,0));
                            $("#FaxNo"            ).val(table.getData(18,0));
                            $("#ZipNo"            ).val(table.getData(19,0));
                            $("#ZipAddr"          ).val(table.getData(20,0));
                            $("#EmailAddr"        ).val(table.getData(21,0));
                            $("#RecvName"         ).val(table.getData(22,0));
                            $("#Desc"             ).val(table.getData(23,0));
                            $("#UseYN"            ).val(table.getData(24,0));
                            $("#CustGu"           ).val(table.getData(25,0));
                            $("#VrCopyCustCdHidn" ).val(table.getData(26,0));
                            $("#VrCopyCustCd"     ).val(table.getData(27,0));

                            changeCustGu(table.getData(25,0));

                            Search2(table.getData(0,0));
                        }
                        */
        }

        function Search2(CustCd) {
            /*
            *             {name:'CompCdName',  index:'CompCdName',  align:'center', width:'200px'},
                        {name:'VrAcntYn',  index:'VrAcntYn',  align:'center',  editable:true, edittype:'checkbox', editoptions:{name:'VrAcntYn', value:'Y:N'}},
                        {name:'VrAcntCopyYn',    index:'VrAcntCopyYn',    align:'center', width:'220px', editable:true, edittype:'checkbox', editoptions:{name:'VrAcntCopyYn', value:'Y:N'}},
                        {name:'VrAcntNo',    index:'VrAcntNo',    align:'left', width:'220px', editable:false},
                        {name:'CmBankName',  index:'CmBankName',  align:'center', width:'250px', editable:true, edittype:'select', editoptions:{dataUrl:'/customer/CMP0100301SBankOption?codeDiv=020&companyID=000001', buildSelect:setSelectCombo}},
                        {name:'SaverName', index:'SaverName', align:'center', editable:true, edittype:'text', editoptions: {size:20, maxlength:'255'}},
                        {name:'AcntNo', index:'AcntNo', align:'center', editable:true, edittype:'text', editoptions: {size:20, maxlength:'255'}},
                        {name:'CmPayTermName', index:'CmPayTermName', align:'center', width:'250px', editable:true, edittype:'select', editoptions:{dataUrl:'/customer/CMP0100301STermOption?codeDiv=083&companyID=000001', buildSelect:setSelectCombo2}},
                        {name:'CustCd', index:'CustCd', align:'center', width:'40px'},
                        {name:'CompCd', index:'CompCd', align:'center', width:'40px'}*/
            jQuery.post('/customer/CMP010104S_ACCOUNT', {CustCd:CustCd}, function(data2) {
                var result = jQuery.parseJSON(data2);
                if(result.success == 'Y') {
                    if(result.data.length > 0) {
                        console.log(result.data);
                        for(var i=0;i<result.data.length;i++) {
                            var dat = result.data[i];
                            var rowid = i + 1;
                            $('#'+gridWrapper2).jqGrid('setCell', rowid, 'CompCdName', dat.CompCdName);
                            //$('#'+gridWrapper).jqGrid('setCell', rowid, 'VrAcntYn', dat.VrAcntYn);
                            //$('#'+gridWrapper).jqGrid('setCell', rowid, 'VrAcntCopyYn', dat.VrAcntCopyYn);
                            if(dat.VrAcntYn === 'Y') {
                                $('#'+rowid+'_VrAcntYn').prop('checked', true);
                            } else {
                                $('#'+rowid+'_VrAcntYn').prop('checked', false);
                            }

                            if(dat.VrAcntYn === 'Y') {
                                $('#'+rowid+'_VrAcntCopyYn').prop('checked', true);
                            } else {
                                $('#'+rowid+'_VrAcntCopyYn').prop('checked', false);
                            }
                            if(typeof dat.VrAcntNo !== 'undefined' && dat.VrAcntNo !== '') {
                                $('#'+gridWrapper2).jqGrid('setCell', rowid, 'VrAcntNo', dat.VrAcntNo);
                            } else {
                                $('#'+gridWrapper2).jqGrid('setCell', rowid, 'VrAcntNo');
                            }

                            if(typeof dat.CmBankCd !== 'undefined' && dat.CmBankCd !== '') {
                                $('#'+rowid+'_CmBankName').val(dat.CmBankCd).prop("selected", true);
                            } else {
                                $('#'+rowid+'_CmBankName').val('').prop("selected", true);
                            }
                            if(typeof dat.SaverName !== 'undefined' && dat.SaverName !== '') {
                                $('#'+rowid+'_SaverName').val(dat.SaverName);
                            } else {
                                $('#'+rowid+'_SaverName').val('');
                            }
                            if(typeof dat.AcntNo !== 'undefined' && dat.AcntNo !== '') {
                                $('#'+rowid+'_AcntNo').val(dat.AcntNo);
                            } else {
                                $('#'+rowid+'_AcntNo').val('');
                            }
                            if(typeof dat.CmPayTermCd !== 'undefined' && dat.CmPayTermCd !== '') {
                                $('#'+rowid+'_CmPayTermName').val(dat.CmPayTermCd).prop("selected", true);
                            } else {
                                $('#'+rowid+'_CmPayTermName').val('').prop("selected", true);
                            }

                            /*
                                                        table.getData(colIdx++,i), //[VrAcntNo]
                                                        table.getData(colIdx++,i), //[CmBankName]
                                                        table.getData(colIdx++,i), //[SaverName]
                                                        table.getData(colIdx++,i), //[AcntNo]
                                                        table.getData(colIdx++,i), //[CustCd]
                                                        table.getData(colIdx++,i), //[RegiUser]
                                                        table.getData(colIdx++,i), //[RegiDate]
                                                        table.getData(colIdx++,i), //[ModifyUser]
                                                        table.getData(colIdx++,i), //[ModifyDate]
                                                        table.getData(colIdx++,i), //[CmBankCd]
                                                        table.getData(colIdx++,i),  //[CompCd]
                                                        table.getData(colIdx++,i),
                                                        table.getData(colIdx++,i)
                                                        */
                        }

                    }
                }
            });
            /*
                        var rowCount = table.getCount();
                        if (rowCount > 0) {
                            for (var i=0; i < rowCount; i++) {
                                if(table.getData(1,i).trim() == 'Y'){
                                    grid2.setCellValue(true,1,i);
                                }else{
                                    grid2.setCellValue(false,1,i);
                                }
                                if(table.getData(2,i).trim() == 'Y'){
                                    grid2.setCellValue(true,2,i);
                                }else{
                                    grid2.setCellValue(false,2,i);
                                }
                            }
                        }
            */
        }

        function Search_new() {
            jQuery.post('/customer/CMP010101S', {SysUseYN:'Y'}, function(data2) {
                var result = jQuery.parseJSON(data2);
                if(result.success === 'Y') {
                    if(result.data.length > 0) {
                        for(var i=0;i<result.data.length;i++) {
                            var dat = result.data[i];
                            var gridData = {};

                            console.log(dat);

                            /*
                            {name:'CompCdName',  index:'CompCdName',  align:'center'},
                            {name:'VrAcntYn',  index:'VrAcntYn',  align:'center',  editable:true, edittype:'checkbox', editoptions:{name:'VrAcntYn', value:'Y:N'}},
                            {name:'VrAcntCopyYn',    index:'VrAcntCopyYn',    align:'left', width:'220px', editable:true, edittype:'checkbox', editoptions:{name:'VrAcntCopyYn', value:'Y:N'}},
                            {name:'VrAcntNo',    index:'VrAcntNo',    align:'left', width:'220px'},
                            {name:'CmBankName',  index:'CmBankName',  align:'center'},
                            {name:'SaverName', index:'SaverName', align:'center'},
                            {name:'AcntNo', index:'AcntNo', align:'center'},
                            {name:'CmPayTermName', index:'CmPayTermName', align:'center'},
                            {name:'CustCd', index:'CustCd', align:'center', width:'40px'},
                            {name:'CompCd', index:'CompCd', align:'center', width:'40px'}
                            */
                            gridData.CompCdName = dat.CompName;
                            gridData.VrAcntYn = dat.VrAcntYn === 'Y' ? 'Yes' : 'No';
                            gridData.VrAcntCopyYn = dat.VrAcntCopyYn === 'Y' ? 'Yes' : 'No';
                            gridData.VrAcntNo = dat.VrAcntNo;
                            gridData.CmBankName = "(선택안함)";
                            gridData.SaverName = "";
                            gridData.AcntNo = "";
                            gridData.CmPayTermName = "(선택안함)";
                            gridData.CustCd = dat.CustCd;
                            gridData.CompCd = dat.CompCd;

                            console.log(gridData);

                            $("#"+gridWrapper2).jqGrid('addRowData',i+1,gridData);
                            jQuery('#'+gridWrapper2).jqGrid('editRow',i+1,true);

                        }
//                        jQuery("#"+gridWrapper2).trigger("reloadGrid");
                        window.setTimeout(function() {
                            jQuery('input[type=checkbox]').each(function() {
                                jQuery(this).blur();
                            });
                        },500);
                    }
                } else {

                }
            });
            /*
                        if (rowCount > 0) {
                            var data = new Array();
                            var colIdx = 0;

                            //공통코드에서 가져와서 회사별 리스트만 생성해준다
                            for (var i=0; i < rowCount; i++) {
                                colIdx = 0;
                                data[i] = [
                                    table.getData(1,i), //[CompName]
                                    "", //[VrAcntYn]
                                    "", //[VrAcntCopyYn]
                                    "", //[VrAcntNo]
                                    "(선택안함)", //[CmBankName]
                                    "", //[SaverName]
                                    "", //[AcntNo]
                                    "", //[CustCd]
                                    "", //[RegiUser]
                                    "", //[RegiDate]
                                    "", //[ModifyUser]
                                    "", //[ModifyDate]

                                    "",  //[CmBankCd]
                                    table.getData(0,i), //[CompCd]
                                    "(선택안함)",
                                    ""
                                ];

                                grid2.setCellTemplate(new AW.Templates.CheckBox, 1,i);
                                grid2.setCellTemplate(new AW.Templates.CheckBox, 2,i);
                                if(table.getData(14,i).trim() == 'Y'){
                                    grid2.setCellValue(true,1,i);
                                }else{
                                    grid2.setCellValue(false,1,i);
                                }
                                if(table.getData(15,i).trim() == 'Y'){
                                    grid2.setCellValue(true,2,i);
                                }else{
                                    grid2.setCellValue(false,2,i);
                                }
                            }

                           // grid2.setCellData(data);
                            //grid2.setRowCount(rowCount);
                        }

             */

        }

        function setSelectCombo(data) {
            var result = jQuery.parseJSON(data);
            var resultData = '<select>';
            resultData += '<option value="">(선택안함)</option>';
            for(var idx=0; idx < result.data.length; idx++) {
                var dat = result.data[idx];

                resultData += '<option value="' + dat.comCode + '" data-attrib01="'+dat.attrib01+'">' + dat.codeName + '</option>';

            }

            resultData += '</select>';
            return resultData;

        }

        function setSelectCombo2(data) {
            var result = jQuery.parseJSON(data);
            var resultData = '<select>';
            resultData += '<option value="">(선택안함)</option>';
            for(var idx=0; idx < result.data.length; idx++) {
                var dat = result.data[idx];

                resultData += '<option value="' + dat.comCode + '" data-attrib01="'+dat.attrib01+'">' + dat.codeName + '</option>';

            }

            resultData += '</select>';
            return resultData;
        }

        /**
         * 둘중하나로 조회 해서 있는지 여부 체크
         * 공통 팝업을 엔터키로 띄우기 직전 사용
         */
        function fn_chkCustCount(BizNo, PersonNo) {

            jQuery.post('/customer/COM050107S', {
                C_BizNo   : unformat(BizNo),
                C_PersonNo: unformat(PersonNo)
            }, function (data) {
                var result = jQuery.parseJSON(data);
                if (result.data.length > 0) {
                    return true;
                } else {
                    return false;
                }
            });
        }

        /** 팝업에 넘겨줄 파라미터 값 처리 */
        function setParams_BizNo(id){
            var params = new Array();

            params.push("");
            params.push(unformat($("#BizNo").val()));
            params.push("");

            return params;
        }

        //팝업
        function UpdateFields_BizNo(id, showColmn, hidnColmn, retValue) {
            $("#"+id).val(showColmn);
            $("#"+id+"Hidn").val(hidnColmn);
            if(hidnColmn != ''){
                Search_cust(hidnColmn);
            }
        }

    </script>
    <h3>${documentTitle}</h3>
    <div class="searchForm">
        <form id="fieldSurvForm">
            <input type="hidden" name="gridPage" id="gridPage" value="1">
            <div class="form_input disp_inline">
                <label for="C_CustCd">코드</label>
                <input type="text" id="C_CustCd" name="C_CustCd" value="" style="width:90px">
            </div>
            <div class="form_input disp_inline">
                <label for="C_CustName1">거래처명</label>
                <input type="text" id="C_CustName1" name="C_CustName1" value="" style="width:90px">
            </div>
            <div class="form_input disp_inline">
                <label for="C_BizNo">사업자번호</label>
                <input type="text" id="C_BizNo" name="C_BizNo" value="" style="width:90px">
            </div>
            <div class="form_input disp_inline">
                <label for="C_CustGu" style="color:#444">거래처구분</label>
                <select id="C_CustGu" name="C_CustGu">
                    <option value="">선택</option>
                    <option value="001">개인</option>
                    <option value="002">사업자</option>
                </select>
            </div>
            <div class="form_input disp_inline">
                <label for="C_CmCustTypeCd" style="color:#444">거래처유형</label>
                <select id="C_CmCustTypeCd" name="C_CmCustTypeCd">
                    <option value="">선택</option>
                    <option value="001">광고</option>
                    <option value="002">지국</option>
                    <option value="003">기타</option>
                </select>
            </div>
            <div class="form_input disp_inline">
                <label for="C_SapYn" style="color:#444">SAP전송</label>
                <select id="C_SapYn" name="C_SapYn">
                    <option value="">선택</option>
                    <option value="Y">Y</option>
                    <option value="N">N</option>
                </select>
            </div>
            <div class="form_input disp_inline">
                <label for="C_RepName">대표자명</label>
                <input type="text" id="C_RepName" name="C_RepName" value="" style="width:90px">
            </div>
            <div class="form_input disp_inline last_inline" style="float:right">
                <button type="button" id="searchGridBtn" class="searchGridBtn" style="width:50px">검색</button>
                <button type="button" id="newGridBtn" class="searchGridBtn" style="width:50px">신규</button>
                <button type="button" id="saveGridBtn" class="searchGridBtn" style="width:50px">저장</button>
                <button type="button" id="excelGridBtn" class="searchGridBtn" style="width:50px">엑셀</button>

            </div>
        </form>
    </div>
    <div style="height:1px;clear:both">&nbsp;</div>
    <div class="box_wrapper" style="width:1300px;">
        <table id="inputArea" border="0" cellspacing="0" cellpadding="0" style="margin-top:5px;width:100%">
            <tbody>
            <tr>
                <td class="tb-border">
                    <table border="0" id="box_wrapper_table" cellpadding="3" cellspacing="1" style="border:#e1dcbe solid 1px;width:100%;">
                        <colgroup>
                            <col style="width:90px">
                            <col style="width:160px">
                            <col style="width:60px;">
                            <col style="width:140px">
                            <col style="width:80px">
                            <col style="width:300px">
                            <col style="width:100px">
                            <col style="width:150px">
                            <col style="width:90px">
                            <col style="width:*">
                        </colgroup>
                        <tbody>
                        <tr>
                            <td class="td-cond">거래처코드</td>
                            <td class="td-input">
                                <input type="text" id="CustCd" name="CustCd" class="input-readonly" style="width:100px;background-color:#eee" readonly="readonly">
                            </td>
                            <td class="td-cond-required" style="text-align:left;padding-left:3px;">구분/유형</td>
                            <td class="td-input">
                                <select id="CustGu" name="CustGu" style="width:64px;">
                                    <option value="001">개인</option>
                                    <option value="002">사업자</option>
                                </select>
                                <select id="CmCustTypeCd" name="CmCustTypeCd" style="width:62px;">
                                    <option value="" selected="">(선택)</option>
                                    <option value="001">광고</option>
                                    <option value="002">지국</option>
                                    <option value="003">기타</option>
                                </select>
                            </td>
                            <td class="td-cond">우편주소</td>
                            <td class="td-input"><input type="text" id="ZipNo" name="ZipNo" class="" style="width:50px;background-color:#eee;" maxlength="6" readonly="readonly">
                                <button type="button" id="btnAddr" style="CURSOR: pointer; VERTICAL-ALIGN: middle">찾기</button>
                                <input type="text" id="ZipAddr" name="ZipAddr" style="width:200px;" maxlength="40">
                                <input type="hidden" id="RoadAddr" name="RoadAddr">
                            </td>
                            <td class="td-cond">SAP 벤더코드</td>
                            <td class="td-input"><input type="text" id="ERPVendorCd" name="ERPVendorCd" class="input-readonly" style="width:100px;background-color:#eee;" readonly="readonly"></td>
                            <td class="td-cond">SAP 고객코드</td>
                            <td class="td-input"><input type="text" id="ERPCustCd" name="ERPCustCd" class="input-readonly" style="width:100px;background-color:#eee;" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td class="td-cond-required">거래처명1</td>
                            <td class="td-input" colspan="3"><input type="text" id="CustName1" name="CustName1" style="width:95%;"></td>
                            <td class="td-cond">상세주소</td>
                            <td class="td-input"><input type="text" id="Addr" name="Addr" style="width:286px;" maxlength="40"></td>
                            <td class="td-cond">계좌승계거래처</td>
                            <td class="td-input">
                                <input type="hidden" id="VrCopyCustCd_showColmnIdx" value="0">
                                <input type="hidden" id="VrCopyCustCd_hidnColmnIdx" value="7">
                                <input type="text" id="VrCopyCustCd" name="VrCopyCustCd" style="ime-mode:active;width:100px;">
                                <button type="button" id="openVrCopyCustCdPopup" onclick="javascript:openPopupNew('VrCopyCustCd','COM0501','COM050107','0','7',setParamsForPopup,UpdateFields,800,400);" style="vertical-align:top;cursor:pointer">
                                    &nbsp;검색&nbsp;
                                </button>
                                <input type="hidden" id="VrCopyCustCdHidn" name="VrCopyCustCdHidn" value=""><!--정합성 체크 용도-->
                                <input type="hidden" id="VrCopyCustCd1" name="VrCopyCustCd1">
                            </td>
                            <td class="td-cond-required">사용여부</td>
                            <td class="td-input"><select id="UseYN" name="UseYN" style="width:100px;">	<option value="Y" selected="">Y</option>	<option value="N">N</option></select></td>
                        </tr>
                        <tr>
                            <td class="td-cond">거래처명2</td>
                            <td class="td-input" colspan="3"><input type="text" id="CustName2" name="CustName2" style="width:95%;"></td>
                            <td class="td-cond">비고</td>
                            <td class="td-input"><input type="text" id="Desc" name="Desc" style="width:286px;" maxlength="50"></td>
                            <td class="td-cond">SAP 응답메시지</td>
                            <td class="td-input" colspan="3"><input type="text" id="SAP_RECIVE" name="SAP_RECIVE" class="input-readonly" style="width: 100%;background-color:#eee;border:solid 1px #e1e1e1;" readonly="readonly"></td>
                        </tr>
                        <tr>
                            <td class="td-cond" id="tdBizNo">사업자번호</td>
                            <td class="td-input">
                                <input type="hidden" id="BizNo_showColmnIdx" value="3">
                                <input type="hidden" id="BizNo_hidnColmnIdx" value="7">
                                <input type="text" id="BizNo" name="BizNo" style="ime-mode:active;width:100px;">
                                <button type="button" id="openBizNoPopup" onclick="javascript:openPopupNew('BizNo','COM0501','/customer/COM050111','udateFields_BizNo',1000,500);" style="vertical-align:top;cursor:pointer"> &nbsp;검색&nbsp; </button>
                                <input type="hidden" id="BizNoHidn" name="BizNoHidn"><!--정합성 체크 용도-->
                                <input type="hidden" id="BizNo1" name="BizNo1">
                                <input type="hidden" id="h_BizNo" value="">
                            </td>
                            <td class="td-cond" style="padding-left:5px;">법인번호</td>
                            <td class="td-input"><input type="text" id="CorpNo" name="CorpNo" style="width:120px;" maxlength="13"></td>
                            <td class="td-cond" colspan="6" rowspan="6" valign="top">
                                <!-- 그리드시작 -->
                                <table id="gridAccount"></table>

                            </td>
                        </tr>

                        <tr>
                            <td class="td-cond-required" id="tdPersonNo">주민번호</td>
                            <td class="td-input">
                                <input type="hidden" id="PersonNo_showColmnIdx" value="8">
                                <input type="hidden" id="PersonNo_hidnColmnIdx" value="7">
                                <input type="text" id="PersonNo" name="PersonNo" style="ime-mode:active;width:100px;">
                                <button type=""button id="openPersonNoPopup" onclick="javascript:openPopupNew('PersonNo','COM0501','/customer/COM050111','UpdateFields_PersonNo',1000,500);" style="vertical-align:top;cursor:pointer"> &nbsp;검색&nbsp; </button>
                                <input type="hidden" id="PersonNoHidn" name="PersonNoHidn"><!--정합성 체크 용도-->
                                <input type="hidden" id="PersonNo1" name="PersonNo1">
                                <input type="hidden" id="h_PersonNo" value="540410-1348011">
                            </td>
                            <td class="td-cond" style="padding-left:5px;">대표자명</td>
                            <td class="td-input">
                                <input type="text" id="RepName" name="RepName" style="width:120px;" maxlength="30">
                            </td>

                        </tr>

                        <tr>
                            <td class="td-cond">업태</td>
                            <td class="td-input">
                                <input type="text" id="CompType" name="CompType" maxlength="30" style="width:120px;">
                            </td>
                            <td class="td-cond">업종</td>
                            <td class="td-input">
                                <input type="text" id="CompKind" name="CompKind" maxlength="30" style="width:120px;">
                            </td>
                        </tr>
                        <tr>
                            <td class="td-cond">전화번호</td>
                            <td class="td-input"><input type="text" id="TelNo" name="TelNo" style="width:100px;" maxlength="20"></td>
                            <td class="td-cond" style="padding-left:5px;">팩스번호</td>
                            <td class="td-input"><input type="text" id="FaxNo" name="FaxNo" style="width:120px;" maxlength="20"></td>
                        </tr>
                        <tr>
                            <td class="td-cond">담당자이메일</td>
                            <td class="td-input" colspan="3"><input type="text" id="EmailAddr" name="EmailAddr" style="width:95%;" maxlength="30"></td>

                        </tr>
                        <tr>
                            <td class="td-cond">담당자명</td>
                            <td class="td-input" colspan="3">
                                <input type="text" id="RecvName" name="RecvName" style="width:100px;" maxlength="30">
                            </td>
                        </tr>
                        <tr>
                            <td class="td-cond">File선택</td>
                            <td class="td-input" colspan="3" valign="top">
                                <div style="float:left;margin-left:2px;">
                                    <form action="/service/CMP010104Controller/saveCMP010104_excelToDb" id="ajaxform" name="ajaxform" method="post" enctype="multipart/form-data" style="display: inline;">
                                        <input type="file" name="uploadfile" id="uploadfile" style="width:150px;">
                                        <!-- <input type="hidden" name="U_CompCd" id="U_CompCd" /> -->
                                    </form>
                                </div>

                                <div style="float:left;margin-left:2px;">
                                    <button type="button" onclick="InsertExcelToDb();" class="btn_03">
                                        엑셀업로드
                                    </button>
                                </div>

                            </td>
                        </tr>
                        </tbody>
                    </table>
                </td>
            </tr>
            </tbody></table>
    </div>
    <div class="data_result_wrap">
        <!--
                    <table id="listTable">
                        <tr>
                            <th style='text-align:center;width:200px;height:30px;background:#e1e1e1'>CustCd</th>
                            <th style='text-align:center;width:200px;height:30px;background:#e1e1e1'>CustName1</th>
                            <th style='text-align:center;width:200px;height:30px;background:#e1e1e1'>CustGuName</th>
                            <th style='text-align:center;width:200px;height:30px;background:#e1e1e1'>CustGuCd</th>
                        </tr>
        //-->
        <table id="mainGrid2"></table>
        <div id="gridPager"></div>
        <!--
                    </table>
        //-->
    </div>

</div>
<div style="clear:both"></div>

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    window.onload = function(){
        document.getElementById("btnAddr").addEventListener("click", function(){ //주소입력칸을 클릭하면
            //카카오 지도 발생
            new daum.Postcode({
                oncomplete: function(data) { //선택시 입력값 세팅
                    console.log(data);
                    document.getElementById('ZipNo').value = data.zonecode;
                    document.getElementById("ZipAddr").value = data.address; // 주소 넣기
                    document.querySelector("input[name=RoadAddr]").focus(); //상세입력 포커싱
                }
            }).open();
        });
    }
</script>

<%@ include file="/WEB-INF/views/foot.jsp" %>
