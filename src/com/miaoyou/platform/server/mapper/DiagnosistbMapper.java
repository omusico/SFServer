package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.DiagnosistbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiagnosistbMapper {
    int countByExample(DiagnosistbExample example);

    int deleteByExample(DiagnosistbExample example);

    int deleteByPrimaryKey(Long diagnosisId);

    int insert(Diagnosistb record);

    int insertSelective(Diagnosistb record);

    List<Diagnosistb> selectByExample(DiagnosistbExample example);

    Diagnosistb selectByPrimaryKey(Long diagnosisId);

    int updateByExampleSelective(@Param("record") Diagnosistb record, @Param("example") DiagnosistbExample example);

    int updateByExample(@Param("record") Diagnosistb record, @Param("example") DiagnosistbExample example);

    int updateByPrimaryKeySelective(Diagnosistb record);

    int updateByPrimaryKey(Diagnosistb record);
}