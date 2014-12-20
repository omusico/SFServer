package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.PatienttbExample;
import com.miaoyou.platform.server.entity.PatienttbWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatienttbMapper {
    int countByExample(PatienttbExample example);

    int deleteByExample(PatienttbExample example);

    int deleteByPrimaryKey(Long patientid);

    int insert(PatienttbWithBLOBs record);

    int insertSelective(PatienttbWithBLOBs record);

    List<PatienttbWithBLOBs> selectByExampleWithBLOBs(PatienttbExample example);

    List<Patienttb> selectByExample(PatienttbExample example);

    PatienttbWithBLOBs selectByPrimaryKey(Long patientid);

    int updateByExampleSelective(@Param("record") PatienttbWithBLOBs record, @Param("example") PatienttbExample example);

    int updateByExampleWithBLOBs(@Param("record") PatienttbWithBLOBs record, @Param("example") PatienttbExample example);

    int updateByExample(@Param("record") Patienttb record, @Param("example") PatienttbExample example);

    int updateByPrimaryKeySelective(PatienttbWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PatienttbWithBLOBs record);

    int updateByPrimaryKey(Patienttb record);
}