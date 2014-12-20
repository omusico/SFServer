package com.miaoyou.platform.server.service.patient;

import com.miaoyou.platform.server.entity.Patientsurveytb;
import com.miaoyou.platform.server.entity.Rspatientsurveysv;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;
import com.miaoyou.platform.server.service.CommServiceIF;
import com.miaoyou.platform.server.utils.Pager;

public interface PatientSurveyServiceIF extends CommServiceIF<Patientsurveytb,Long> {

	public int saveAnwser(Long patientsurveyId, SurveyDetailtb surveyDetailtb);
	
	public CommFindEntity<Rspatientsurveysv> findAllAnwser(Pager pager,Long patientsurveyId);
	
}
