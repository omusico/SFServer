package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.SfplanHistorytb;
import com.miaoyou.platform.server.entity.SfplanHistorytbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfplanHistorytbMapper {
    int countByExample(SfplanHistorytbExample example);

    int deleteByExample(SfplanHistorytbExample example);

    int deleteByPrimaryKey(Long planId);

    int insert(SfplanHistorytb record);

    int insertSelective(SfplanHistorytb record);

    List<SfplanHistorytb> selectByExample(SfplanHistorytbExample example);

    SfplanHistorytb selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") SfplanHistorytb record, @Param("example") SfplanHistorytbExample example);

    int updateByExample(@Param("record") SfplanHistorytb record, @Param("example") SfplanHistorytbExample example);

    int updateByPrimaryKeySelective(SfplanHistorytb record);

    int updateByPrimaryKey(SfplanHistorytb record);
}