package com.hkilbo.hkrms.customer.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.hkilbo.hkrms.customer.vo.CustCdVo;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface Customer2Mapper {
    ArrayList<CustCdVo> CMP010104S(Map map);
    ArrayList<CustCdVo> CMP010104S2(Map map);
    ArrayList<CustCdVo> CMP010101S(Map map);
    ArrayList<Map> CMP0100301S(Map map);
    ArrayList<Map> COM050107S(Map map);
    ArrayList<Map> CMP010104S_ACCOUNT(Map map);
    void CMP010104I(Map map);
    Map CMP010104U(Map map);
    void CMP010104D_ACCOUNT(Map map);
    Map COM010104S_Bank(Map map);
    Map CMP010104_CodeName(Map map);
    Map CMP010104_Attrib01_CodeName(Map map);
    void CMP010104I_LOG(Map map);
    void CMP010104U_ACCOUNT(Map map);
    void CMP010104I_ACCOUNT(Map map);
}