package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rskeshidns;
import com.miaoyou.platform.server.entity.RskeshidnsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RskeshidnsMapper {
    int countByExample(RskeshidnsExample example);

    int deleteByExample(RskeshidnsExample example);

    int insert(Rskeshidns record);

    int insertSelective(Rskeshidns record);

    List<Rskeshidns> selectByExample(RskeshidnsExample example);

    int updateByExampleSelective(@Param("record") Rskeshidns record, @Param("example") RskeshidnsExample example);

    int updateByExample(@Param("record") Rskeshidns record, @Param("example") RskeshidnsExample example);
}