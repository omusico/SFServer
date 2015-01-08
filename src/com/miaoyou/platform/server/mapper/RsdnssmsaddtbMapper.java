package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rsdnssmsaddtb;
import com.miaoyou.platform.server.entity.RsdnssmsaddtbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsdnssmsaddtbMapper {
    int countByExample(RsdnssmsaddtbExample example);

    int deleteByExample(RsdnssmsaddtbExample example);

    int insert(Rsdnssmsaddtb record);

    int insertSelective(Rsdnssmsaddtb record);

    List<Rsdnssmsaddtb> selectByExample(RsdnssmsaddtbExample example);

    int updateByExampleSelective(@Param("record") Rsdnssmsaddtb record, @Param("example") RsdnssmsaddtbExample example);

    int updateByExample(@Param("record") Rsdnssmsaddtb record, @Param("example") RsdnssmsaddtbExample example);
}