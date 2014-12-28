package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rsplantelsv;
import com.miaoyou.platform.server.entity.RsplantelsvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RsplantelsvMapper {
    int countByExample(RsplantelsvExample example);

    int deleteByExample(RsplantelsvExample example);

    int deleteByPrimaryKey(Long planId);

    int insert(Rsplantelsv record);

    int insertSelective(Rsplantelsv record);

    List<Rsplantelsv> selectByExample(RsplantelsvExample example);

    Rsplantelsv selectByPrimaryKey(Long planId);

    int updateByExampleSelective(@Param("record") Rsplantelsv record, @Param("example") RsplantelsvExample example);

    int updateByExample(@Param("record") Rsplantelsv record, @Param("example") RsplantelsvExample example);

    int updateByPrimaryKeySelective(Rsplantelsv record);

    int updateByPrimaryKey(Rsplantelsv record);
}