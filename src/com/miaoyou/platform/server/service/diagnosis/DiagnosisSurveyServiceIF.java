package com.miaoyou.platform.server.service.diagnosis;

import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.child.SurveyModelEntity;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.utils.Pager;

public interface DiagnosisSurveyServiceIF {
	
	public CommFindEntity<Surveytb> findSurvey(Long diagnosisId);
	
	public CommFindEntity<Surveytb> findAllSurveyWithAddedSurvey(Long diagnosisId,Integer departmentId);
		
	public SurveyModelEntity findDnsModelAllWithAddedQuestion(Pager page, Long surveryId,Long diagnosisId,Integer departmentId);
	
	public SurveyModelEntity findDnsModelAllWithAddedQuestionForPatientDefaultSurvey(Pager page, Long patientId,Long surveryId);
	
	public int deleteDnsSurveyModel(Long surveryId,Long diagnosisId);
	
	public int saveDnsSurveyModel(Long surveryId,Long diagnosisId);
	
	public int saveDnsSurveyModelWithAddedSurvey(Integer departmentId,Long diagnosisId,Long surveryId);
	
	public int saveDnsSurveyModelWidthAddedQuestion(SurveyDetailtb surveyDetailtb,Integer departmentId,Long diagnosisId,Long surveryId);
	
	public int deleteDnsSurveyModelAddedQuestion(Long surverydetailId,Integer departmentId,Long diagnosisId,Long surveryId);
	public int deleteDnsSurveyModelAddedSurvey(Integer departmentId,Long diagnosisId,Long surveryId);
}
