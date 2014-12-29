package com.miaoyou.platform.server.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RssvsvdtbKey  implements Serializable {
    private Long surveryId;

    private Long surverydetailId;

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