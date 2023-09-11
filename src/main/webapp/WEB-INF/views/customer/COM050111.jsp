<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%! Boolean isPopup = true; %>
<%@ include file="../top.jsp" %>

    <div style="margin-left:4px;margin-top:5px">

        <script>
            var popupDataType1 = "${dataType1}";
            var popupData1 = "${data1}";
            var gridTitle = "${documentTitle}";
            let gridMsg = "&nbsp; TOTAL : <span id='gridTotal'>0건</span>";
            var collbackStr = "${callback}";

            /*
         grid data 페이징용 세팅
          */
            var setCustCd = "";
            var loading = "";
            var gridRowNum = 50;
            var gridDataType = "local";
            const searchResultColNames =  [
                "거래처명1",
                "거래처명2",
                "거래처구분",
                "사업자번호",
                "대표자명",
                "업태",
                "주소",
                "거래처코드",
                "주민번호"
            ];

            const searchResultColModel =  [
                {name:'CustName1',    index:'CustName1',    align:'left', width:'220px'},
                {name:'CustName2',    index:'CustName2',    align:'left', width:'220px'},
                {name:'CustGuName',  index:'CustGuName',  align:'center'},
                {name:'BizNo', index:'BizNo', align:'center'},
                {name:'RepName', index:'RepName', align:'center'},
                {name:'CompType', index:'CompType', align:'center'},
                {name:'Addrs', index:'Addrs', align:'center',width:'300px'},
                {name:'CustCd',  index:'CustCd',  align:'center'},
                {name:'PersonNo', index:'PersonNo', align:'center'},
            ];

            var gridPage = 1;
            var gridPager = "#pager";
            var gridWrapper = "gridMain";
            var selectedCustCd = "";
            var selectedRow = "";

            $(function() {

                $("#showId").val("${dataType}");

                jQuery("#"+gridWrapper).jqGrid({
                    colNames: searchResultColNames,
                    colModel: searchResultColModel,
                    rowNum : gridRowNum,
                    pager : gridPager,
                    height: 370,
                    width: 990,
                    caption : gridTitle + gridMsg,
                    onSelectRow : function(rowId, status, e) {
                        selectedRow = rowId;
                        var selData = $('#' + gridWrapper).jqGrid('getRowData', rowId);
                        selectedCustCd = selData.CustCd;
                    },
                    onPaging : function(dd) {
                        if(dd === 'next_pager') {

                        }
                    }
                });

                Search();

                $('#confirmBtn').bind('click',function() {
                    if(selectedCustCd === '' || selectedRow === '') {
                        alert('거래처를 선택해주세요.');  return false;
                    }
                   Choice(selectedRow);
                });
                $('#closeBtn').bind('click',function() {
                   window.close();
                });
            });

            function Search() {
                gridLoader(true, 'small');
                var BizNo = "";
                var PersonNo = "";
                if(popupDataType1 == 'BizNo') {
                    BizNo = popupData1;
                } else {
                    PersonNo = popupData1;
                }
                $('#'+gridWrapper).jqGrid('clearGridData', true);
                jQuery.post('/customer/COM050107S', {C_BizNo:BizNo, C_PersonNo:PersonNo, C_CustName:""}, function(data2) {
                    var result = jQuery.parseJSON(data2);
                    if(result.success == 'Y') {
                        if(result.data.length > 0) {
                            var realData = [];
                            for(var i=0;i<result.data.length;i++) {
                                var dat = result.data[i];
                                var gridData = {};
                                gridData.BizNo = typeof dat.BizNo !== 'undefined' ? dat.BizNo : '';
                                gridData.CompType = typeof dat.CompType !== 'undefined' ? dat.CompType : '';
                                gridData.CustCd = typeof dat.CustCd !== 'undefined' ? dat.CustCd : '';
                                gridData.CustGu = typeof dat.CustGu !== 'undefined' ? dat.CustGu : '';
                                gridData.CustGuName = typeof dat.CustGuName !== 'undefined' ? dat.CustGuName : '';
                                gridData.CustName1 = typeof dat.CustName1 !== 'undefined' ? dat.CustName1 : '';
                                gridData.CustName2 = typeof dat.CustName2 !== 'undefined' ? dat.CustName2 : '';
                                gridData.PersonNo = typeof dat.PersonNo !== 'undefined' ? dat.PersonNo : '';
                                gridData.RepName = typeof dat.RepName !== 'undefined' ? dat.RepName : '';

                                $("#"+gridWrapper).jqGrid('addRowData',i+1,gridData);
                                //realData.push(realData);
                            }
/*
                            jQuery("#"+gridWrapper).jqGrid('setGridParam',

                                {
                                    datatype: 'local',
                                    data:realData
                                })

                                .trigger("reloadGrid");
*/
                        }
                    } else {
                        $('#'+gridWrapper).jqGrid('clearGridData', true);
                    }
                    gridLoader(false);
                });
                //CustName1;CustName2;CustGu;BizNo;RepName;CompType;Addr;CustCd;PersonNo;CustGuName
        /*
                var rowCount = table.getCount();
                if (rowCount > 0) {
                    var data = new Array();
                    for (var i=0; i < rowCount; i++) {
                        data[i] = [
                            table.getData(0,i),	//CustName1
                            table.getData(1,i),	//CustName2
                            table.getData(2,i),	//CustGu
                            table.getData(3,i),	//BizNo
                            table.getData(4,i),	//RepName
                            table.getData(5,i),	//CompType
                            table.getData(6,i),	//Addr
                            table.getData(7,i),	//CustCd
                            table.getData(8,i),	//PersonNo
                            table.getData(9,i),	//CustGuName
                        ];
                    }

                }
        */
            }

            /** 선택 (값전달) */
            function Choice(rowId){
                var selData = $('#'+gridWrapper).jqGrid('getRowData', rowId);
                selectedCustCd = selData.CustCd;

                if( popupDataType1 === 'PersonNo' ) {
                    var PersonNo = selData.PersonNo;
                    window.opener.UpdateFields_PersonNo('PersonNo', PersonNo, selectedCustCd);
                } else {
                    var BizNo = selData.BizNo;
                    window.opener.UpdateFields_BizNo('BizNo', BizNo, selectedCustCd);
                }
                window.close ();
            }

            function Cancel() {
                window.close();
            }
        </script>

        <input type="hidden" id="showId" value="" />
        <input type="hidden" id="showColmnIdx" value="" />
        <input type="hidden" id="hidnColmnIdx" value="" />
        <input type="hidden" id="funcID" name="funcID">
        <input type="hidden" id="currentFuncCode" name="currentFuncCode">
        <input type="hidden" id="uniqueYN" name="uniqueYN" value="N">

        <table id="gridMain" style=""></table>
        <div id="pager"></div>
        <div style="">
            <div style="float:right;margin-right:20px;">
                <button type="button" class="wide" id="confirmBtn">&nbsp;선택&nbsp;</button> <button class="wide" type="button" id="closeBtn">&nbsp;취소&nbsp;</button>
            </div>
        </div>

    </div>

</div>
</body>
</html>