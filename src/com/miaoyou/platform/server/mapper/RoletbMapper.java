package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Roletb;
import com.miaoyou.platform.server.entity.RoletbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoletbMapper {
    int countByExample(RoletbExample example);

    int deleteByExample(RoletbExample example);

    int deleteByPrimaryKey(Integer roleId);

    int insert(Roletb record);

    int insertSelective(Roletb record);

    List<Roletb> selectByExample(RoletbExample example);

    Roletb selectByPrimaryKey(Integer roleId);

    int updateByExampleSelective(@Param("record") Roletb record, @Param("example") RoletbExample example);

    int updateByExample(@Param("record") Roletb record, @Param("example") RoletbExample example);

    int updateByPrimaryKeySelective(Roletb record);

    int updateByPrimaryKey(Roletb record);
}