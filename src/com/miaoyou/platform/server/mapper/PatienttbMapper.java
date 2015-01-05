package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Patienttb;
import com.miaoyou.platform.server.entity.PatienttbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatienttbMapper {
    int countByExample(PatienttbExample example);

    int deleteByExample(PatienttbExample example);

    int deleteByPrimaryKey(Long patientid);

    int insert(Patienttb record);

    int insertSelective(Patienttb record);

    List<Patienttb> selectByExample(PatienttbExample example);

    Patienttb selectByPrimaryKey(Long patientid);

    int updateByExampleSelective(@Param("record") Patienttb record, @Param("example") PatienttbExample example);

    int updateByExample(@Param("record") Patienttb record, @Param("example") PatienttbExample example);

    int updateByPrimaryKeySelective(Patienttb record);

    int updateByPrimaryKey(Patienttb record);
}