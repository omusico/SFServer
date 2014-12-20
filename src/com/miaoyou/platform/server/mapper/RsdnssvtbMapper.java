package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.RsdnssvtbExample;
import com.miaoyou.platform.server.entity.RsdnssvtbKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsdnssvtbMapper {
    int countByExample(RsdnssvtbExample example);

    int deleteByExample(RsdnssvtbExample example);

    int deleteByPrimaryKey(RsdnssvtbKey key);

    int insert(RsdnssvtbKey record);

    int insertSelective(RsdnssvtbKey record);

    List<RsdnssvtbKey> selectByExample(RsdnssvtbExample example);

    int updateByExampleSelective(@Param("record") RsdnssvtbKey record, @Param("example") RsdnssvtbExample example);

    int updateByExample(@Param("record") RsdnssvtbKey record, @Param("example") RsdnssvtbExample example);
}