package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Usertb;
import com.miaoyou.platform.server.entity.UsertbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsertbMapper {
    int countByExample(UsertbExample example);

    int deleteByExample(UsertbExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(Usertb record);

    int insertSelective(Usertb record);

    List<Usertb> selectByExample(UsertbExample example);

    Usertb selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") Usertb record, @Param("example") UsertbExample example);

    int updateByExample(@Param("record") Usertb record, @Param("example") UsertbExample example);

    int updateByPrimaryKeySelective(Usertb record);

    int updateByPrimaryKey(Usertb record);
}