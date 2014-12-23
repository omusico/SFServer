package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rsdnssvtbadd implements Serializable {
    private Long diagnosisId;

    private Integer departmentId;

    private Long surveryId;

    private Long surverydetailId;

    public Long getDiagnosisId() {
        return diagnosisId;
    }

    public void setDiagnosisId(Long diagnosisId) {
        this.diagnosisId = diagnosisId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
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