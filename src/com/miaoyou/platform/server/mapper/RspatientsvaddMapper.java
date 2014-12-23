package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rspatientsvadd;
import com.miaoyou.platform.server.entity.RspatientsvaddExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RspatientsvaddMapper {
    int countByExample(RspatientsvaddExample example);

    int deleteByExample(RspatientsvaddExample example);

    int insert(Rspatientsvadd record);

    int insertSelective(Rspatientsvadd record);

    List<Rspatientsvadd> selectByExample(RspatientsvaddExample example);

    int updateByExampleSelective(@Param("record") Rspatientsvadd record, @Param("example") RspatientsvaddExample example);

    int updateByExample(@Param("record") Rspatientsvadd record, @Param("example") RspatientsvaddExample example);
}