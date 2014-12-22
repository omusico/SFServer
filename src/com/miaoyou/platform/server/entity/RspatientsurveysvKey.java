package com.miaoyou.platform.server.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RspatientsurveysvKey implements Serializable{
    private Long patientsurveyId;

    private Long surveryId;

    public Long getPatientsurveyId() {
        return patientsurveyId;
    }

    public void setPatientsurveyId(Long patientsurveyId) {
        this.patientsurveyId = patientsurveyId;
    }

    public Long getSurveryId() {
        return surveryId;
    }

    public void setSurveryId(Long surveryId) {
        this.surveryId = surveryId;
    }
}