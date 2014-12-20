package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.SurveytbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveytbMapper {
    int countByExample(SurveytbExample example);

    int deleteByExample(SurveytbExample example);

    int deleteByPrimaryKey(Long surveryId);

    int insert(Surveytb record);

    int insertSelective(Surveytb record);

    List<Surveytb> selectByExample(SurveytbExample example);

    Surveytb selectByPrimaryKey(Long surveryId);

    int updateByExampleSelective(@Param("record") Surveytb record, @Param("example") SurveytbExample example);

    int updateByExample(@Param("record") Surveytb record, @Param("example") SurveytbExample example);

    int updateByPrimaryKeySelective(Surveytb record);

    int updateByPrimaryKey(Surveytb record);
}