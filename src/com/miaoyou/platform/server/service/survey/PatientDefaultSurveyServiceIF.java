package com.miaoyou.platform.server.service.survey;

import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;

public interface PatientDefaultSurveyServiceIF {
	public CommFindEntity<Surveytb> findPatientSurvey(Long patientId);
	
	public int savePatientSv(Long patientId,Long surveyId);
	
	public int deletePatientSv(Long patientId,Long surveyId);
}
