package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Sfplantb;
import com.miaoyou.platform.server.entity.SfplantbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfplantbMapper {
    int countByExample(SfplantbExample example);

    int deleteByExample(SfplantbExample example);

    int deleteByPrimaryKey(Long planId);

    int insert(Sfplantb record);

    int insertSelective(Sfplantb record);

    List<Sfplantb> selectByExample(SfplantbExample example);

    Sfplantb selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") Sfplantb record, @Param("example") SfplantbExample example);

    int updateByExample(@Param("record") Sfplantb record, @Param("example") SfplantbExample example);

    int updateByPrimaryKeySelective(Sfplantb record);

    int updateByPrimaryKey(Sfplantb record);
}