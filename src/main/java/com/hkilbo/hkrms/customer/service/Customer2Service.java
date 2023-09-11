package com.hkilbo.hkrms.customer.service;

import com.hkilbo.hkrms.customer.mapper.Customer2Mapper;
import com.hkilbo.hkrms.customer.vo.CustCdVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Customer2Service {

    @Autowired
    Customer2Mapper customer2Mapper;

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
}