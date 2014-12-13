package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Logtb;
import com.miaoyou.platform.server.entity.LogtbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogtbMapper {
    int countByExample(LogtbExample example);

    int deleteByExample(LogtbExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(Logtb record);

    int insertSelective(Logtb record);

    List<Logtb> selectByExample(LogtbExample example);

    Logtb selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") Logtb record, @Param("example") LogtbExample example);

    int updateByExample(@Param("record") Logtb record, @Param("example") LogtbExample example);

    int updateByPrimaryKeySelective(Logtb record);

    int updateByPrimaryKey(Logtb record);
}