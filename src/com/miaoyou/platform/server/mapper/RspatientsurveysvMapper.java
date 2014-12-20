package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Rspatientsurveysv;
import com.miaoyou.platform.server.entity.RspatientsurveysvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RspatientsurveysvMapper {
    int countByExample(RspatientsurveysvExample example);

    int deleteByExample(RspatientsurveysvExample example);

    int insert(Rspatientsurveysv record);

    int insertSelective(Rspatientsurveysv record);

    List<Rspatientsurveysv> selectByExample(RspatientsurveysvExample example);

    int updateByExampleSelective(@Param("record") Rspatientsurveysv record, @Param("example") RspatientsurveysvExample example);

    int updateByExample(@Param("record") Rspatientsurveysv record, @Param("example") RspatientsurveysvExample example);
}