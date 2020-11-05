package com.snowball.patsupport.bean;

import lombok.Data;

@Data
public class CityInfo {
    //城市代码
    private String appCode;
    //城市名称
    private String name;
    //城市模式(1.0 or 2.0)
    private String cityType;
    //是否是DP模式
    private boolean isDP;
    //是否支持欲解绑
    private boolean isSupportPreUnbind;
    //是否有冲正(圈存状态同步:失败或者成功)
    private boolean hasSyncOrderStatus;
    //是否有建账
    private boolean hasMakeBil;

}
