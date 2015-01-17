package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.sfplansmsHistorytb;
import com.miaoyou.platform.server.entity.sfplansmsHistorytbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface sfplansmsHistorytbMapper {
    int countByExample(sfplansmsHistorytbExample example);

    int deleteByExample(sfplansmsHistorytbExample example);

    int deleteByPrimaryKey(Long smsplanId);

    int insert(sfplansmsHistorytb record);

    int insertSelective(sfplansmsHistorytb record);

    List<sfplansmsHistorytb> selectByExample(sfplansmsHistorytbExample example);

    sfplansmsHistorytb selectByPrimaryKey(Long smsplanId);

    int updateByExampleSelective(@Param("record") sfplansmsHistorytb record, @Param("example") sfplansmsHistorytbExample example);

    int updateByExample(@Param("record") sfplansmsHistorytb record, @Param("example") sfplansmsHistorytbExample example);

    int updateByPrimaryKeySelective(sfplansmsHistorytb record);

    int updateByPrimaryKey(sfplansmsHistorytb record);
}