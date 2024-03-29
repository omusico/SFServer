/*
 * 2014 Chengdu JunChen Technology
 */
package com.miaoyou.platform.server.entity.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author 305027939
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ComResponse<T> {

    public final static int STATUS_OK = 0;

    public final static int STATUS_FAIL = 1;

    public final static int STATUS_TIMEOUT = 2;

    private int responseStatus;

    private String errorMessage;

    /*因为spring的框架的限制，请暂时不要为responseEntity设置值，暂时保持null*/
    private T responseEntity;

    private String extendResponseContext;

    /**
     * @return the responseStatus
     */
    public int getResponseStatus() {
        return responseStatus;
    }

    /**
     * @param responseStatus the responseStatus to set
     */
    public void setResponseStatus(int responseStatus) {
        this.responseStatus = responseStatus;
    }

    /**
     * @return the errorMessage
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    /**
     * @param errorMessage the errorMessage to set
     */
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    /**
     * @return the responseEntity
     */
    public T getResponseEntity() {
        return responseEntity;
    }

    /**
     * @param responseEntity the responseEntity to set
     */
    public void setResponseEntity(T responseEntity) {
        this.responseEntity = responseEntity;
    }

    /**
     * @return the extendResponseContext
     */
    public String getExtendResponseContext() {
        return extendResponseContext;
    }

    /**
     * @param extendResponseContext the extendResponseContext to set
     */
    public void setExtendResponseContext(String extendResponseContext) {
        this.extendResponseContext = extendResponseContext;
    }

}
