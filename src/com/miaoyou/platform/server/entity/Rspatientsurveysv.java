package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rspatientsurveysv implements Serializable {
    private Long patientsurveyId;

    private String surverydetailName;

    private String surverydetailAnswer;

    public Long getPatientsurveyId() {
        return patientsurveyId;
    }

    public void setPatientsurveyId(Long patientsurveyId) {
        this.patientsurveyId = patientsurveyId;
    }

    public String getSurverydetailName() {
        return surverydetailName;
    }

    public void setSurverydetailName(String surverydetailName) {
        this.surverydetailName = surverydetailName == null ? null : surverydetailName.trim();
    }

    public String getSurverydetailAnswer() {
        return surverydetailAnswer;
    }

    public void setSurverydetailAnswer(String surverydetailAnswer) {
        this.surverydetailAnswer = surverydetailAnswer == null ? null : surverydetailAnswer.trim();
    }
}