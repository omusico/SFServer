package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Appparamtb;
import com.miaoyou.platform.server.entity.AppparamtbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppparamtbMapper {
    int countByExample(AppparamtbExample example);

    int deleteByExample(AppparamtbExample example);

    int deleteByPrimaryKey(Integer appparamId);

    int insert(Appparamtb record);

    int insertSelective(Appparamtb record);

    List<Appparamtb> selectByExample(AppparamtbExample example);

    Appparamtb selectByPrimaryKey(Integer appparamId);

    int updateByExampleSelective(@Param("record") Appparamtb record, @Param("example") AppparamtbExample example);

    int updateByExample(@Param("record") Appparamtb record, @Param("example") AppparamtbExample example);

    int updateByPrimaryKeySelective(Appparamtb record);

    int updateByPrimaryKey(Appparamtb record);
}