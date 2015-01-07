package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Smstypetb;
import com.miaoyou.platform.server.entity.SmstypetbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmstypetbMapper {
    int countByExample(SmstypetbExample example);

    int deleteByExample(SmstypetbExample example);

    int deleteByPrimaryKey(Long smstypeId);

    int insert(Smstypetb record);

    int insertSelective(Smstypetb record);

    List<Smstypetb> selectByExample(SmstypetbExample example);

    Smstypetb selectByPrimaryKey(Long smstypeId);

    int updateByExampleSelective(@Param("record") Smstypetb record, @Param("example") SmstypetbExample example);

    int updateByExample(@Param("record") Smstypetb record, @Param("example") SmstypetbExample example);

    int updateByPrimaryKeySelective(Smstypetb record);

    int updateByPrimaryKey(Smstypetb record);
}