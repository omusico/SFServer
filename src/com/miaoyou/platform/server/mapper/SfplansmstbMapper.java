package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Sfplansmstb;
import com.miaoyou.platform.server.entity.SfplansmstbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfplansmstbMapper {
    int countByExample(SfplansmstbExample example);

    int deleteByExample(SfplansmstbExample example);

    int deleteByPrimaryKey(Long smsplanId);

    int insert(Sfplansmstb record);

    int insertSelective(Sfplansmstb record);

    List<Sfplansmstb> selectByExample(SfplansmstbExample example);

    Sfplansmstb selectByPrimaryKey(Long smsplanId);

    int updateByExampleSelective(@Param("record") Sfplansmstb record, @Param("example") SfplansmstbExample example);

    int updateByExample(@Param("record") Sfplansmstb record, @Param("example") SfplansmstbExample example);

    int updateByPrimaryKeySelective(Sfplansmstb record);

    int updateByPrimaryKey(Sfplansmstb record);
}