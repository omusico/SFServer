package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Smstb;
import com.miaoyou.platform.server.entity.SmstbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmstbMapper {
    int countByExample(SmstbExample example);

    int deleteByExample(SmstbExample example);

    int deleteByPrimaryKey(Long smsId);

    int insert(Smstb record);

    int insertSelective(Smstb record);

    List<Smstb> selectByExample(SmstbExample example);

    Smstb selectByPrimaryKey(Long smsId);

    int updateByExampleSelective(@Param("record") Smstb record, @Param("example") SmstbExample example);

    int updateByExample(@Param("record") Smstb record, @Param("example") SmstbExample example);

    int updateByPrimaryKeySelective(Smstb record);

    int updateByPrimaryKey(Smstb record);
}