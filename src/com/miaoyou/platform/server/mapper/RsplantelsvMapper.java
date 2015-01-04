package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.RsplantelsvExample;
import com.miaoyou.platform.server.entity.RsplantelsvKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsplantelsvMapper {
    int countByExample(RsplantelsvExample example);

    int deleteByExample(RsplantelsvExample example);

    int deleteByPrimaryKey(RsplantelsvKey key);

    int insert(RsplantelsvKey record);

    int insertSelective(RsplantelsvKey record);

    List<RsplantelsvKey> selectByExample(RsplantelsvExample example);

    int updateByExampleSelective(@Param("record") RsplantelsvKey record, @Param("example") RsplantelsvExample example);

    int updateByExample(@Param("record") RsplantelsvKey record, @Param("example") RsplantelsvExample example);
}