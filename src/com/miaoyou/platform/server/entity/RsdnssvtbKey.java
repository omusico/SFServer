package com.miaoyou.platform.server.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RsdnssvtbKey implements Serializable {
    private Long diagnosisId;

    private Long surveryId;

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Long getSurveryId() {
        return surveryId;
    }

    public void setSurveryId(Long surveryId) {
        this.surveryId = surveryId;
    }
}