package com.hkilbo.hkrms.customer.service;

import com.hkilbo.hkrms.customer.mapper.Code2Mapper;
import com.hkilbo.hkrms.customer.vo.CodeVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodeService {

    @Autowired
    Code2Mapper code2Mapper;

    public Map getSeqID(CodeVo code) {
        Map nMap2 = new HashMap();
        nMap2.put("seqDiv", code.getSeqDiv());
        code2Mapper.SYS0005U(nMap2);
        Map nMap = new HashMap();
        nMap.put("seqDiv", code.getSeqDiv());
        return code2Mapper.SYS0006S(nMap);
    }
//
//    public void rollbackSeq(Code code) throws Exception {
//        code2Mapper.SYS0006S(nMap);
//    }

/*
    public ArrayList<CustCdVo> CMP010104S(Map map){
        return customer2Mapper.CMP010104S(map);
    }

    public ArrayList<CustCdVo> CMP010104S2(Map map){
        return customer2Mapper.CMP010104S2(map);
    }

    public ArrayList<CustCdVo> CMP010101S(Map map) {
        return customer2Mapper.CMP010101S(map);
    }

    public List<Map> CMP0100301S(Map map) {
        return customer2Mapper.CMP0100301S(map);
    }

    public List<Map> COM050107S(Map map) {
        return customer2Mapper.COM050107S(map);
    }

    public List<Map> CMP010104S_ACCOUNT(Map map) {
        return customer2Mapper.CMP010104S_ACCOUNT(map);
    }

 */
}