package com.hkilbo.hkrms.customer.mapper;

import com.hkilbo.hkrms.customer.vo.CodeVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@Mapper
public interface Code2Mapper {
        void SYS0005U(Map map);
        Map SYS0006S(Map map);
}