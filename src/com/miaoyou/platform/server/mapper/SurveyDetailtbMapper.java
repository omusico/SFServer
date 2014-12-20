package com.miaoyou.platform.server.mapper;

import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.SurveyDetailtbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SurveyDetailtbMapper {
    int countByExample(SurveyDetailtbExample example);

    int deleteByExample(SurveyDetailtbExample example);

    int deleteByPrimaryKey(Long surverydetailId);

    int insert(SurveyDetailtb record);

    int insertSelective(SurveyDetailtb record);

    List<SurveyDetailtb> selectByExample(SurveyDetailtbExample example);

    SurveyDetailtb selectByPrimaryKey(Long surverydetailId);

    int updateByExampleSelective(@Param("record") SurveyDetailtb record, @Param("example") SurveyDetailtbExample example);

    int updateByExample(@Param("record") SurveyDetailtb record, @Param("example") SurveyDetailtbExample example);

    int updateByPrimaryKeySelective(SurveyDetailtb record);

    int updateByPrimaryKey(SurveyDetailtb record);
}