package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.Diagnosistb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DnsSurveyModelEntity extends Diagnosistb implements Serializable{
	
	private CommFindEntity<SurveyModelEntity> surveyModeArray;

	public CommFindEntity<SurveyModelEntity> getSurveyModeArray() {
		return surveyModeArray;
	}

	public void setSurveyModeArray(CommFindEntity<SurveyModelEntity> surveyModeArray) {
		this.surveyModeArray = surveyModeArray;
	}
	
}
