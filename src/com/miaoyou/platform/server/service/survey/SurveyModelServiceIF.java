package com.miaoyou.platform.server.service.survey;

import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.utils.Pager;

public interface SurveyModelServiceIF {
	public SurveyModelEntity findModelAll(Pager page, Long surveryId);
	
	public int deleteSurveyModelQuestion(SurveyDetailtb surveyDetailtb,Long surveryId);
	
	public int saveSurveyModelQuestion(SurveyDetailtb surveyDetailtb,Long surveryId);
	
	public int updateSurveyModelDefaultAnwser(SurveyDetailtb surveyDetailtb,Long surveryId);
}
