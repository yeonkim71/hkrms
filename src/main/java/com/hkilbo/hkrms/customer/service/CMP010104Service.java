package com.hkilbo.hkrms.customer.service;

import java.util.HashMap;
import java.util.Map;

import com.hkilbo.hkrms.customer.mapper.Customer2Mapper;
//import com.sun.deploy.security.JarSignature;

import com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ;
import com.hkilbo.hkrms.ECC.FI37.FI37_MIS_REQ_SOServiceLocator;
import com.hkilbo.hkrms.ECC.FI37.FI37_MIS_RESP;
import com.hkilbo.hkrms.ECC.FI37.HkibUtil;

import com.hkilbo.hkrms.customer.vo.XiCon;
import jakarta.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * @author lee
 * 거래처 계좌 리스트 저장
 */
@Service
public class CMP010104Service {

    @Autowired
    Customer2Mapper customer2Mapper;

    @Resource
    XiCon xiConfigure;
/*
    xi.ip=gcawpoodv1.dongwha.com
    xi.port=50000
    xi.userName=xiappluser
    xi.password=dongwhaappl
    xi.fi37.channel
  */
    @Value("${xi.ip}")
    private String xiIp;

    @Value("${xi.password}")
    private String xiPassword;

    @Value("${xi.port}")
    private String xiPort;

    @Value("${xi.userName}")
    private String xiUserName;

    @Value("${xi.fi37.channel}")
    private String xiFi37Channel;

    public Map save(Map map) throws Exception {
        Map resutl= new HashMap();
        String msg="";
        HkibUtil util = new HkibUtil();
        String str []= util.getStringArray(map.get("screenValCompCd"));
        String CustCd = (String) map.get("CustCd");
        String eRPVrCopyCustCd = "";
        if(!StringUtils.isEmpty((String) map.get("VrCopyCustCd"))){
            eRPVrCopyCustCd = "HK"+(String) map.get("VrCopyCustCd");
        }
        if(!StringUtils.isEmpty((String) map.get("ERPCustCd"))){
            map.put("ERPCustCd", "HK"+CustCd);
        }
        if(!StringUtils.isEmpty((String) map.get("ERPVendorCd"))){
            map.put("ERPVendorCd", "HK"+CustCd);
        }
        if("I".equals(map.get("type"))){
            customer2Mapper.CMP010104I(map);
        }else{
            //수정
            customer2Mapper.CMP010104U(map);
        }

        if (str != null && str.length > 0) {
            customer2Mapper.CMP010104D_ACCOUNT(map);
            int erpCnt=0;

            Map tmp1 = null;
            Map content = null;
            String strCodeName = null;

            String[] screenValCompCdArr = StringUtils.split((String) map.get("screenValCompCd"), ',');
            String[] screenValVrAcntNoArr = StringUtils.split((String) map.get("screenValVrAcntNo"), ',');
            String[] screenValCmBankCdArr = StringUtils.split((String) map.get("screenValCmBankCd"), ',');
            String[] screenValSaverNameArr = StringUtils.split((String) map.get("screenValSaverName"), ',');
            String[] screenValAcntNoArr = StringUtils.split((String) map.get("screenValAcntNo"), ',');
            String[] screenValVrAcntYnArr = StringUtils.split((String) map.get("screenValVrAcntYn"), ',');
            String[] screenValVrAcntCopyYnArr = StringUtils.split((String) map.get("screenValVrAcntCopyYn"), ',');
            String[] screenCmPayTermCdArr = StringUtils.split((String) map.get("screenCmPayTermCd"), ',');

            for (int i=0; i < str.length; i++) {

                Map parm = new HashMap();
                if("nodata".equals(screenValCompCdArr[i])) {
                    parm.put("CompCd", "");
                } else {
                    parm.put("CompCd", screenValCompCdArr[i]);
                }
                if("nodata".equals(screenValVrAcntNoArr[i])) {
                    parm.put("VrAcntNo", "");
                } else {
                    parm.put("VrAcntNo", screenValVrAcntNoArr[i]);
                }
                if("nodata".equals(screenValCmBankCdArr[i])) {
                    parm.put("CmBankCd", "");
                } else {
                    parm.put("CmBankCd", screenValCmBankCdArr[i]);
                }
                if("nodata".equals(screenValSaverNameArr[i])) {
                    parm.put("SaverName", "");
                } else {
                    parm.put("SaverName", screenValSaverNameArr[i]);
                }
                if("nodata".equals(screenValAcntNoArr[i])) {
                    parm.put("AcntNo", "");
                } else {
                    parm.put("AcntNo", screenValAcntNoArr[i]);
                }
                if("nodata".equals(screenValVrAcntYnArr[i])) {
                    parm.put("VrAcntYn", "");
                } else {
                    parm.put("VrAcntYn", screenValVrAcntYnArr[i]);
                }
                if("nodata".equals(screenValVrAcntCopyYnArr[i])) {
                    parm.put("VrAcntCopyYn", "");
                } else {
                    parm.put("VrAcntCopyYn", screenValVrAcntCopyYnArr[i]);
                }
                if("nodata".equals(screenCmPayTermCdArr[i])) {
                    parm.put("CmPayTermCd", "");
                } else {
                    parm.put("CmPayTermCd", screenCmPayTermCdArr[i]);
                }

                parm.put("CustCd", map.get("CustCd"));
                parm.put("RegiUser", map.get("RegiUser"));
                parm.put("ModifyUser", map.get("ModifyUser"));

                //sap if
                String successYn="" ;
                String vrAcntNo="";
                try{
                    Map mapTrust = new HashMap();
                    //전송변수
                    String compCd      = (String) parm.get("CompCd");
                    String custCd      = (String) map.get("CustCd");
                    String eRPCustCd   = (String) map.get("ERPCustCd");
                    String eRPVendorCd = (String) map.get("ERPVendorCd");
                    String custGu      = (String) map.get("CustGu");
                    String custName1   = (String) map.get("CustName1");
                    String custName2   = (String) map.get("CustName2");
                    String bizNo       = (String) map.get("BizNo");
                    String corpNo      = (String) map.get("CorpNo");
                    String personNo    = (String) map.get("PersonNo");
                    String repName     = (String) map.get("RepName");
                    String compType    = (String) map.get("CompType");
                    String compKind    = (String) map.get("CompKind");
                    String zipNo       = (String) map.get("ZipNo");
                    String addr        = (String) map.get("ZipAddr")+" "+(String) map.get("Addr");

                    String zipAddr = (String) map.get("ZipAddr"); //주소
                    String addr2 = (String) map.get("Addr"); //상세주소


                    String emailAddr   = (String) map.get("EmailAddr");
                    String recvName    = (String) map.get("RecvName");
                    String telNo       = (String) map.get("TelNo");
                    String faxNo       = (String) map.get("FaxNo");
                    //eRPVrCopyCustCd
                    String iFCode      = "";
                    String CmBankCd    = !StringUtils.isEmpty((String) parm.get("CmBankCd")) ? (String) parm.get("CmBankCd") : "";
                    if(!"".equals(CmBankCd)){
                        Map sapCode    = customer2Mapper.COM010104S_Bank(parm);
                        iFCode         = (String) sapCode.get("IFCode");
                    }
                    String saverName   = (String) parm.get("SaverName");
                    String acntNo      = (String) parm.get("AcntNo");
                    String vrAcntCopyYn= (String) parm.get("VrAcntCopyYn");
                    String vrAcntYn    = (String) parm.get("VrAcntYn");

                    String custType = (String) map.get("CmCustTypeCd"); //거래처유형
                    String payTerm = (String) parm.get("CmPayTermCd"); //지급조건

                    //인터페이스 시작
                    FI37_MIS_REQ req = new FI37_MIS_REQ();
                    //변수 VO에 셋팅
                    req.setCompCd(compCd);
                    req.setCustCd(custCd);
                    req.setERPCustCd(eRPCustCd);
                    req.setERPVendorCd(eRPVendorCd);
                    req.setCustGu(custGu);

                    if("".equals(custType.trim())){
                        req.setCustType("");
                    }else{
                        tmp1 = new HashMap();
                        tmp1.put("codeDiv", "082");
                        tmp1.put("comCode", custType);
                        content = customer2Mapper.CMP010104_CodeName(tmp1);
                        strCodeName = (String) content.get("codeName");
                        req.setCustType(strCodeName); //거래처유형(광고,지국,기타 : 한글로 넘겨야 함)
                    }

                    req.setCustName1(custName1);
                    req.setCustName2(custName2);
                    req.setBizNo(bizNo);
                    req.setCorpNo(corpNo);
                    req.setPersonNo(personNo);
                    req.setRepName(repName);
                    req.setCompType(compType);
                    req.setCompKind(compKind);
                    req.setZipNo(zipNo);
                    req.setZipAddr(zipAddr); //주소
                    req.setAddr(addr2); //상세주소
                    req.setEmailAddr(emailAddr);
                    req.setRecvName(recvName);
                    req.setTelNo(telNo);
                    req.setFaxNo(faxNo);
                    req.setOrgERPCustCd(eRPVrCopyCustCd);
                    req.setCmBankCd(iFCode);
                    req.setSaverName(saverName);
                    req.setAcntNo(acntNo);
                    req.setVrAcntCopyYN(vrAcntCopyYn);
                    req.setVrAcntNoYN(vrAcntYn);

                    if("".equals(payTerm.trim())){
                        req.setPayTerm("");
                    }else{
                        tmp1 = new HashMap();
                        tmp1.put("codeDiv", "083");
                        tmp1.put("comCode", payTerm);
                        content = customer2Mapper.CMP010104_Attrib01_CodeName(tmp1);
                        strCodeName = (String) content.get("codeName");
                        req.setPayTerm(strCodeName); //지급조건-SAP코드 넘겨야 함.
                    }

                    xiConfigure.setIp(xiIp);
                    xiConfigure.setPort(xiPort);
                    xiConfigure.setUserName(xiUserName);
                    xiConfigure.setPassword(xiPassword);
                    xiConfigure.setFi37Channel(xiFi37Channel);

                    System.out.println(xiConfigure.getIp());
                    System.out.println(xiConfigure.getPort());
                    System.out.println(xiConfigure.getFi37Channel());
                    System.out.println(xiConfigure.getUserName());
                    System.out.println(xiConfigure.getPassword());

                    System.out.println(req);

                    //호출
                    FI37_MIS_RESP resp = new FI37_MIS_REQ_SOServiceLocator(xiConfigure.getIp(),xiConfigure.getPort(),xiConfigure.getFi37Channel()).getFI37_MIS_REQ_SOPort().FI37_MIS_REQ_SO(req,xiConfigure.getUserName(),xiConfigure.getPassword());
                    //결과값
                    successYn = resp.getSuccessYN();
                    vrAcntNo = resp.getVrAcntNo();
                    if("".equals(msg)){
                        msg += resp.getMessage();
                    }else{
                        msg += "| "+resp.getMessage();
                    }
                    //로그변수 생성
                    Map logparm = new HashMap();
                    logparm.put( "CompCd"           ,compCd         );
                    logparm.put( "CustCd"           ,custCd         );
                    logparm.put( "ERPCustCd"        ,eRPCustCd      );
                    logparm.put( "ERPVendorCd"      ,eRPVendorCd    );
                    logparm.put( "CustGu"           ,custGu         );
                    logparm.put( "CustName1"        ,custName1      );
                    logparm.put( "CustName2"        ,custName2      );
                    logparm.put( "BizNo"            ,bizNo          );
                    logparm.put( "CorpNo"           ,corpNo         );
                    logparm.put( "PersonNo"         ,personNo       );
                    logparm.put( "CompType"         ,compType       );
                    logparm.put( "CompKind"         ,compKind       );
                    logparm.put( "RepName"          ,repName        );
                    logparm.put( "TelNo"            ,telNo          );
                    logparm.put( "FaxNo"            ,faxNo          );
                    logparm.put( "ZipNo"            ,zipNo          );


                    //logparm.put( "Addr"             ,addr           );
                    logparm.put( "ZipAddr"             ,zipAddr           );
                    logparm.put( "Addr"             ,addr2           );


                    logparm.put( "EmailAddr"        ,emailAddr      );
                    logparm.put( "RecvName"         ,recvName       );
                    logparm.put( "BankCd"           ,iFCode        );
                    logparm.put( "AcntNo"           ,acntNo        );
                    logparm.put( "SaverName"        ,saverName     );
                    logparm.put( "VrAcntYN"         ,vrAcntYn      );
                    logparm.put( "VrAcntCopyYN"     ,vrAcntCopyYn  );
                    logparm.put( "VrCopyCustCd"     ,eRPVrCopyCustCd);
                    logparm.put( "VrAcntNo"         ,vrAcntNo);
                    logparm.put( "TYPE"             ,successYn);
                    logparm.put( "MESSAGE"          ,resp.getMessage());
                    logparm.put( "RegiUser"         , map.get("RegiUser"));

                    logparm.put( "CustType"         , custType);
                    logparm.put( "PayTerm"         , payTerm);

                    //로그생성
                    customer2Mapper.CMP010104I_LOG(logparm);
                }catch (Exception e) {
                    e.printStackTrace();
                    successYn ="E";
                }

                if("S".equals(successYn)){
                    parm.put("VrAcntNo" , vrAcntNo);
                    erpCnt++;
                }else if("E".equals(successYn)){
                    //erpCnt++;
                }
                String vcc = "";
                if(map.get("VrCopyCustCd") != null) {
                    vcc = (String) map.get("VrCopyCustCd");
                    vcc = vcc.replace(" ", "");
                } else {
                    vcc = "";
                }
                String van = "";
                if(parm.get("VrAcntNo") != null) {
                    van = (String) parm.get("VrAcntNo");
                    van = van.replace(" ","");
                } else {
                    van = "";
                }

                //계좌복사일경우 기존꺼 지워주기...
                if(!"".equals(vcc)
                        && "S".equals(successYn) && "Y".equals((String) parm.get("VrAcntYn"))
                        && !"".equals(van)
                        && "Y".equals((String) parm.get("VrAcntCopyYn")) ){
                    customer2Mapper.CMP010104U_ACCOUNT(parm);
                }
                customer2Mapper.CMP010104I_ACCOUNT(parm);
            }
            if(str.length > erpCnt){
                resutl.put("erpResult","E");
            }else{
                resutl.put("erpResult","S");
            }
            resutl.put("erpMsg",msg);
        }
        return resutl;
    }

    public void excelUpload(Map map) throws Exception {
        map.put("BizNo" , map.get("BizNo").toString().replaceAll("-",""));
        map.put("PersonNo" , map.get("PersonNo").toString().replaceAll("-",""));
    }

}
