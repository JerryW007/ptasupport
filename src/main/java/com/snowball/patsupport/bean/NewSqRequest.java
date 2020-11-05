package com.snowball.patsupport.bean;



import com.snowball.patsupport.utils.UidUtil;
import lombok.Data;

import java.util.List;

@Data
public class NewSqRequest {

    private String orderNo;
    private String refundNo;
    private String currentStep;
    private Integer actionType;
    private String cplc;
    private String deviceVendor;
    private String deviceModel;
    private String userId;
    private String money;
    private String voucherCode;
    private String cardAts;
    private String session;
    private String channelType;
    private String packageName;
    private String merchantId;
    private String orderType;
    private int persoPayMoney;
    private int persoDestMoney;
    private int topupPayMoney;
    private int topupDestMoney;
    private String notifyUrl;
    private String payMethod;
    private String refundReason;
    private String oemVendor;
    private String cardNo;

    public static NewSqRequest NewSqRequestForQueryBalance(String[] data){
        NewSqRequest sqRequest = new NewSqRequest();
        sqRequest.cplc = data[0];
        sqRequest.orderNo = data[1];
        sqRequest.cardNo = data[2];
        sqRequest.actionType = 6;
        sqRequest.currentStep = "BOF";
        sqRequest.deviceVendor = "xiaomi";
        sqRequest.deviceModel = "umi";
        sqRequest.voucherCode = sqRequest.orderNo;
        sqRequest.cardAts = null != sqRequest.cplc ? UidUtil.getAts(sqRequest.cplc) : "";
        return sqRequest;
    }

    public static NewSqRequest NewSqRequestForApplyCancelOrder(String[] data){
        NewSqRequest sqRequest = new NewSqRequest();
        sqRequest.cplc = data[0];
        sqRequest.orderNo = data[1];
        sqRequest.refundNo = sqRequest.orderNo;
        sqRequest.cardNo = data[2];
        sqRequest.actionType = 6; //好卡删卡
        sqRequest.currentStep = "BOF";
        sqRequest.cardAts = null != sqRequest.cplc ? UidUtil.getAts(sqRequest.cplc) : "";
        return sqRequest;
    }

    public static NewSqRequest NewSqRequestForQueryOrderStatus(String[] data){
        NewSqRequest sqRequest = new NewSqRequest();
        sqRequest.cplc = data[0];
        sqRequest.orderNo = data[1];
        sqRequest.cardNo = data[2];
        sqRequest.actionType = 0;
        sqRequest.currentStep = "BOF";
        sqRequest.cardAts = null != sqRequest.cplc ? UidUtil.getAts(sqRequest.cplc) : "";
        return sqRequest;
    }
}

