package com.miaoyou.platform.server.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rsdnssmsaddtb implements Serializable {
    private Long diagnosisId;

    private Integer departmentId;

    private String smsName;

    private String smstypeName;

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

    public String getSmsName() {
        return smsName;
    }

    public void setSmsName(String smsName) {
        this.smsName = smsName == null ? null : smsName.trim();
    }

    public String getSmstypeName() {
        return smstypeName;
    }

    public void setSmstypeName(String smstypeName) {
        this.smstypeName = smstypeName == null ? null : smstypeName.trim();
    }
}