package com.miaoyou.platform.server.entity;

import java.io.Serializable;

public class RsdnssvtbaddKey implements Serializable{
    private Long diagnosisId;

    private Integer departmentId;

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
}