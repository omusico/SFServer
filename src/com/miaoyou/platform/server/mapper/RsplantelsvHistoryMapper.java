package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.RsplantelsvHistoryExample;
import com.miaoyou.platform.server.entity.RsplantelsvHistoryKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsplantelsvHistoryMapper {
    int countByExample(RsplantelsvHistoryExample example);

    int deleteByExample(RsplantelsvHistoryExample example);

    int deleteByPrimaryKey(RsplantelsvHistoryKey key);

    int insert(RsplantelsvHistoryKey record);

    int insertSelective(RsplantelsvHistoryKey record);

    List<RsplantelsvHistoryKey> selectByExample(RsplantelsvHistoryExample example);

    int updateByExampleSelective(@Param("record") RsplantelsvHistoryKey record, @Param("example") RsplantelsvHistoryExample example);

    int updateByExample(@Param("record") RsplantelsvHistoryKey record, @Param("example") RsplantelsvHistoryExample example);
}