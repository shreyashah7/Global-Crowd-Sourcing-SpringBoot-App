/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.freelancer.utility;

/**
 *
 * @author shahs
 */
public class ResponseFormat {

    private Object data;
    private Integer defaultErrorCode;
    private Integer defaultStatusCode;
    private Meta meta;

    public ResponseFormat() {
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getDefaultErrorCode() {
        return defaultErrorCode;
    }

    public void setDefaultErrorCode(Integer defaultErrorCode) {
        this.defaultErrorCode = defaultErrorCode;
    }

    public Integer getDefaultStatusCode() {
        return defaultStatusCode;
    }

    public void setDefaultStatusCode(Integer defaultStatusCode) {
        this.defaultStatusCode = defaultStatusCode;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(String message) {
        Meta meta = new Meta();
        meta.setMessage(message);
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "ResponseFormat{" + "data=" + data + ", defaultErrorCode=" + defaultErrorCode + ", defaultStatusCode=" + defaultStatusCode + ", meta=" + meta + '}';
    }
    
}
