package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.RssvsvdtbExample;
import com.miaoyou.platform.server.entity.RssvsvdtbKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RssvsvdtbMapper {
    int countByExample(RssvsvdtbExample example);

    int deleteByExample(RssvsvdtbExample example);

    int deleteByPrimaryKey(RssvsvdtbKey key);

    int insert(RssvsvdtbKey record);

    int insertSelective(RssvsvdtbKey record);

    List<RssvsvdtbKey> selectByExample(RssvsvdtbExample example);

    int updateByExampleSelective(@Param("record") RssvsvdtbKey record, @Param("example") RssvsvdtbExample example);

    int updateByExample(@Param("record") RssvsvdtbKey record, @Param("example") RssvsvdtbExample example);
}