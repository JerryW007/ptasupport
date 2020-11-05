package com.snowball.patsupport.bean;

public class KvSqBean {
    private String merchantCode;
    private String data;
    private String timestamp;
    private String sign;

    public KvSqBean(){}

    public KvSqBean(String timestamp, String data){
        this.timestamp = timestamp;
        this.data = data;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
