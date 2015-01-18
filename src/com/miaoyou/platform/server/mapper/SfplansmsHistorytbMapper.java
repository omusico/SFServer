package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.SfplansmsHistorytb;
import com.miaoyou.platform.server.entity.SfplansmsHistorytbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SfplansmsHistorytbMapper {
    int countByExample(SfplansmsHistorytbExample example);

    int deleteByExample(SfplansmsHistorytbExample example);

    int deleteByPrimaryKey(Long smsplanId);

    int insert(SfplansmsHistorytb record);

    int insertSelective(SfplansmsHistorytb record);

    List<SfplansmsHistorytb> selectByExample(SfplansmsHistorytbExample example);

    SfplansmsHistorytb selectByPrimaryKey(Long smsplanId);

    int updateByExampleSelective(@Param("record") SfplansmsHistorytb record, @Param("example") SfplansmsHistorytbExample example);

    int updateByExample(@Param("record") SfplansmsHistorytb record, @Param("example") SfplansmsHistorytbExample example);

    int updateByPrimaryKeySelective(SfplansmsHistorytb record);

    int updateByPrimaryKey(SfplansmsHistorytb record);
}