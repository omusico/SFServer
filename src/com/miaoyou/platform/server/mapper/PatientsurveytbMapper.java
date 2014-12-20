package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.PatientsurveytbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PatientsurveytbMapper {
    int countByExample(PatientsurveytbExample example);

    int deleteByExample(PatientsurveytbExample example);

    int deleteByPrimaryKey(Long patientsurveyId);

    int insert(Patientsurveytb record);

    int insertSelective(Patientsurveytb record);

    List<Patientsurveytb> selectByExample(PatientsurveytbExample example);

    Patientsurveytb selectByPrimaryKey(Long patientsurveyId);

    int updateByExampleSelective(@Param("record") Patientsurveytb record, @Param("example") PatientsurveytbExample example);

    int updateByExample(@Param("record") Patientsurveytb record, @Param("example") PatientsurveytbExample example);

    int updateByPrimaryKeySelective(Patientsurveytb record);

    int updateByPrimaryKey(Patientsurveytb record);
}