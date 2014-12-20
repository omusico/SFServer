package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.RsdnssvtbaddExample;
import com.miaoyou.platform.server.entity.RsdnssvtbaddKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsdnssvtbaddMapper {
    int countByExample(RsdnssvtbaddExample example);

    int deleteByExample(RsdnssvtbaddExample example);

    int deleteByPrimaryKey(RsdnssvtbaddKey key);

    int insert(RsdnssvtbaddKey record);

    int insertSelective(RsdnssvtbaddKey record);

    List<RsdnssvtbaddKey> selectByExample(RsdnssvtbaddExample example);

    int updateByExampleSelective(@Param("record") RsdnssvtbaddKey record, @Param("example") RsdnssvtbaddExample example);

    int updateByExample(@Param("record") RsdnssvtbaddKey record, @Param("example") RsdnssvtbaddExample example);
}