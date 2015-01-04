package com.miaoyou.platform.server.entity;

import java.io.Serializable;

public class RsplantelsvKey implements Serializable {
    private Long planId;

    private Long surveryId;

    public Long getPlanId() {
        return planId;
    }

    public void setPlanId(Long planId) {
        this.planId = planId;
    }

    public Long getSurveryId() {
        return surveryId;
    }

    public void setSurveryId(Long surveryId) {
        this.surveryId = surveryId;
    }
}