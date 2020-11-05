package com.snowball.patsupport.config;

public class AliyunLogSearchModel {

    /**
     * 厦门查询cplc充值请求参数
     */
    public static final String XIAMEM_RECHARGE_APPLY_REQUEST="{cplc} and topupApply and c.s.p.w.advice.CommonRequestBodyAdvice";

    /**
     * 精准定位圈存第一步读取卡信息的指令结果
     */
    public static final String RECHARGE_FIRST_COMMAND_RESULT= "{bizSerialNo} and commands and result";
}
