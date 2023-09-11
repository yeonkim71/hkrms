package com.hkilbo.hkrms.customer.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import com.hkilbo.hkrms.customer.service.Customer2Service;
import com.hkilbo.hkrms.customer.service.CMP010104Service;
import com.hkilbo.hkrms.customer.service.CodeService;
import com.hkilbo.hkrms.customer.vo.CodeVo;
import com.hkilbo.hkrms.customer.vo.CustCdVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Customer2Controller {

    @Autowired
    Customer2Service customer2Service;

    @Autowired
    CodeService codeService;

    @Resource
    CMP010104Service cmp010104Service;

    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    @RequestMapping("/customer/index")
    public String customer() {
        return "customer/index";
    }

    @ResponseBody
    @RequestMapping(value="/customer/saveCMP010104", method = RequestMethod.POST)
    public String saveCMP010104(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        CodeVo seqID = new CodeVo();
        JSONObject jsonObj = new JSONObject();
        System.out.println((String)allParameters.get("screenValCompCd"));
        System.out.println(seqID);
        try {
            String CustCd = allParameters.get("CustCd") == null ? "" : (String) allParameters.get("CustCd");

            String ERPCustCd = "";
            String ERPVendorCd = "";

            if (CustCd == null || "".equals(CustCd)) {
                //신규

                //채번
                seqID.setSeqDiv("Ct_CustCode");

                System.out.println(CustCd);

                CustCd = codeService.getSeqID(seqID).get("seqID").toString();

                System.out.println(CustCd);

                allParameters.put("CustCd", CustCd);
                allParameters.put("type", "I");

            } else {
                allParameters.put("type", "U");
            }

            String ecc = allParameters.get("ERPCustCd");
            ecc = ecc.replace(" ","");

            if (!"".equals(ecc)) {
                ERPCustCd = ecc;
            } else {
                ERPCustCd = "HK" + CustCd;
            }

            String evc = allParameters.get("ERPVendorCd");
            evc = evc.replace(" ","");

            if (!"".equals(evc)) {
                ERPVendorCd = evc;
            } else {
                ERPVendorCd = "HK" + CustCd;
            }

            Map result = cmp010104Service.save(allParameters);
            String erpResult = (String) result.get("erpResult");
            if ("S".equals(erpResult)) {
                resultDataMap.put("success", "Y");
                resultDataMap.put("code", "0000");
            } else {
                resultDataMap.put("success", "N");
                resultDataMap.put("code", "0001");
                resultDataMap.put("reason", "SAP IF 전송중 오류가 발생하였습니다.");
            }
            jsonObj.put("CustCd", CustCd);
            jsonObj.put("ERPCustCd", ERPCustCd);
            jsonObj.put("ERPVendorCd", ERPVendorCd);
            jsonObj.put("systemMsg", (String) result.get("erpMsg"));

            resultDataMap.put("data", jsonObj);

        } catch (Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("code", "0002");
            resultDataMap.put("reason", "오류 발생");
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }
/*
        try {
            List<Map> list = customer2Service.saveCMP010104(allParameters);
            JSONArray jsonArray = new JSONArray(list);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }
*/
    @ResponseBody
    @RequestMapping(value="/customer/CMP010104S_ACCOUNT", method = RequestMethod.POST)
    public String CMP010104S_ACCOUNT(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        try {
            List<Map> list = customer2Service.CMP010104S_ACCOUNT(allParameters);
            JSONArray jsonArray = new JSONArray(list);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value="/customer/COM050107S", method = RequestMethod.POST)
    public String COM050107S(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        try {
            List<Map> list = customer2Service.COM050107S(allParameters);
            JSONArray jsonArray = new JSONArray(list);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value="/customer/CMP0100301STermOption", method = RequestMethod.GET)
    public String CMP0100301STerm(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        try {
            List<Map> list = customer2Service.CMP0100301S(allParameters);

            List nList = new ArrayList();
            for (var i=0;i<list.size();i++) {
                Map nMap = new HashMap<>();
                Map dataMap = (HashMap) list.get(i);

                nMap.put("comCode", (String) dataMap.get("comCode"));
                nMap.put("codeName", (String) dataMap.get("codeName"));
                nMap.put("attrib01", (String) dataMap.get("attrib01"));

                nList.add(nMap);
            }

            JSONArray jsonArray = new JSONArray(nList);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value="/customer/CMP0100301SBankOption", method = RequestMethod.GET)
    public String CMP0100301SBank(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        try {
            List<Map> list = customer2Service.CMP0100301S(allParameters);

            List nList = new ArrayList();
            for (var i=0;i<list.size();i++) {
                Map nMap = new HashMap<>();
                Map dataMap = (HashMap) list.get(i);

                nMap.put("comCode", (String) dataMap.get("comCode"));
                nMap.put("codeName", (String) dataMap.get("codeName"));
                nMap.put("attrib01", (String) dataMap.get("attrib01"));

                nList.add(nMap);
            }

            JSONArray jsonArray = new JSONArray(nList);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value="/customer/CMP010101S", method = RequestMethod.POST)
    public String CMP010101S(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        try {
            List<CustCdVo> list = customer2Service.CMP010101S(allParameters);
            JSONArray jsonArray = new JSONArray(list);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value="/customer/CMP010104S", method = RequestMethod.POST)
    public String CMP010104S(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        try {
            List<CustCdVo> list = customer2Service.CMP010104S2(allParameters);
            JSONArray jsonArray = new JSONArray(list);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @ResponseBody
    @RequestMapping(value="/customer/customerSearch", method = RequestMethod.POST)
    public String customerSearch(@RequestParam Map<String, String> allParameters) throws SQLException {
        Map resultDataMap = new HashMap();
        String gridPage = (String) allParameters.get("gridPage");
        resultDataMap.put("gridPage", gridPage);
        try {
            List<CustCdVo> list = customer2Service.CMP010104S(allParameters);

            List nList = new ArrayList();
            for (CustCdVo custCdVo : list) {
                Map nMap = new HashMap<>();

                nMap.put("rownum", custCdVo.getrownum());
                nMap.put("CustCd", custCdVo.getCustCd());
                nMap.put("CustName1", custCdVo.getCustName1());
                nMap.put("CustName2", custCdVo.getCustName2());
                nMap.put("CustGuName", custCdVo.getCustGuName());
                nMap.put("CustGu", custCdVo.getCustGu());
                nMap.put("BizNo", custCdVo.getBizNo());
                nMap.put("RepName", custCdVo.getRepName());
                nMap.put("CompKind", custCdVo.getCompKind());
                nMap.put("CompType", custCdVo.getCompType());
                nMap.put("Addrs", custCdVo.getAddrs());
                nMap.put("ERPVendorCd", custCdVo.getERPVendorCd());
                nMap.put("ERPCustCd", custCdVo.getERPCustCd());
                nMap.put("RegiUser", custCdVo.getRegiUser());
                nMap.put("RegiDate", custCdVo.getRegiDate());
                nMap.put("ModifyUser", custCdVo.getModifyUser());
                nMap.put("ModifyDate", custCdVo.getModifyDate());
                nMap.put("Addrs", custCdVo.getAddrs());


                nList.add(nMap);
            }
            JSONArray jsonArray = new JSONArray(nList);

            resultDataMap.put("success", "Y");
            resultDataMap.put("code", "0000");
            resultDataMap.put("data", jsonArray);

            //request.setAttribute("returnData", jsonArray);
        } catch(Exception e) {
            resultDataMap.put("success", "N");
            resultDataMap.put("reason", e.getMessage());
            resultDataMap.put("code", e.toString());
        }
        JSONObject jsonObject = new JSONObject(resultDataMap);
        return jsonObject.toString();
    }

    @RequestMapping(value="/customer/CMP010104", method = RequestMethod.GET)
    public ModelAndView customerList(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "거래처 조회");
        mav.addObject("UserId", "ADMIN");
        mav.setViewName("customer/customerlist");

        return mav;
    }

    @RequestMapping(value="/customer/CMP010105", method = RequestMethod.GET)
    public ModelAndView customerlist2(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "거래처 조회 신청");
        mav.setViewName("customer/customerlist2");
        return mav;
    }

    @RequestMapping(value="/customer/customerlist3", method = RequestMethod.GET)
    public ModelAndView customerlist3(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "거래처 일괄 신청");
        mav.setViewName("customer/customerlist3");
        return mav;
    }

    @RequestMapping(value="/customer/customerlist4", method = RequestMethod.GET)
    public ModelAndView customerlist4(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "거래처 결과 및 등록");
        mav.setViewName("customer/customerlist4");
        return mav;
    }

    @RequestMapping(value="/customer/customerlist5", method = RequestMethod.GET)
    public ModelAndView customerlist5(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "거래처 요청 확인");
        mav.setViewName("customer/customerlist5");
        return mav;
    }



    @RequestMapping(value="/customer/COM050111", method = RequestMethod.GET)
    public ModelAndView COM050111(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "중복리스트확인");
        mav.addObject("dataType1", request.getParameter("dataType1"));
        mav.addObject("data1", request.getParameter("data1"));
        mav.addObject("callbank", request.getParameter("callbank"));
        mav.setViewName("customer/COM050111");
        return mav;
    }


    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView mainPage(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "메인화면");
        mav.addObject("UserId", "ADMIN");
        mav.setViewName("index");

        return mav;
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public ModelAndView mainHomePage(HttpServletRequest request) throws SQLException {
        ModelAndView mav = new ModelAndView();
        mav.addObject("documentTitle", "메인화면");
        mav.addObject("UserId", "ADMIN");
        mav.setViewName("index");

        return mav;
    }

    /*

    public Map connection(Map map) throws SQLException {
        try (Connection connection = dataSource2.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            map.put("URL", metaData.getURL());
            map.put("DriverName", metaData.getDriverName());
            map.put("UserNmae", metaData.getUserName());
        }
        return map;
    }

     */
/*

    @RequestMapping(value = "/customer/list", method = RequestMethod.GET)
    public ModelAndView mssql(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView();
        List<Map> list = service.CMP010104S();
         mav.addObject("list", list);
        mav.setViewName("/customer/customerlist");
        return mav;
    }
 */
}