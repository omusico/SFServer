package com.miaoyou.platform.server.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RsdnssvtbaddKey implements Serializable{
    private Long diagnosisId;

    private Long surveryId;

    private Long surverydetailId;

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

    public Long getSurverydetailId() {
        return surverydetailId;
    }

    public void setSurverydetailId(Long surverydetailId) {
        this.surverydetailId = surverydetailId;
    }
}