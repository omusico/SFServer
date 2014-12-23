package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rsdnssvtbadd;
import com.miaoyou.platform.server.entity.RsdnssvtbaddExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsdnssvtbaddMapper {
    int countByExample(RsdnssvtbaddExample example);

    int deleteByExample(RsdnssvtbaddExample example);

    int insert(Rsdnssvtbadd record);

    int insertSelective(Rsdnssvtbadd record);

    List<Rsdnssvtbadd> selectByExample(RsdnssvtbaddExample example);

    int updateByExampleSelective(@Param("record") Rsdnssvtbadd record, @Param("example") RsdnssvtbaddExample example);

    int updateByExample(@Param("record") Rsdnssvtbadd record, @Param("example") RsdnssvtbaddExample example);
}