package com.miaoyou.platform.server.entity.child;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miaoyou.platform.server.entity.SurveyDetailtb;
import com.miaoyou.platform.server.entity.Surveytb;
import com.miaoyou.platform.server.entity.common.CommFindEntity;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SurveyModelEntity extends Surveytb implements Serializable{

	private CommFindEntity<SurveyDetailtb> surveyArray;

	public CommFindEntity<SurveyDetailtb> getSurveyArray() {
		return surveyArray;
	}

	public void setSurveyArray(CommFindEntity<SurveyDetailtb> surveyArray) {
		this.surveyArray = surveyArray;
	}
	
	
	
}
