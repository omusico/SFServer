package com.miaoyou.platform.server.service.diagnosis;

import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;

public interface DiagnosisSurveyServiceIF {
	
	public CommFindEntity<Surveytb> findSurvey(Long diagnosisId);
	
	public SurveyModelEntity findDnsModelAll(Pager page, Long surveryId,Long diagnosisId);
	
	public int deleteDnsSurveyModel(Long surveryId,Long diagnosisId);
	
	public int saveDnsSurveyModel(Long surveryId,Long diagnosisId);
	
	public int saveDnsSurveyModelQuestion(SurveyDetailtb surveyDetailtb,Long diagnosisId,Long surveryId);
	
	public int deleteDnsSurveyModelAddedQuestion(Long surverydetailId,Long diagnosisId,Long surveryId);
}
