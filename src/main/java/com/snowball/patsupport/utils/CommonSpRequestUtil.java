package com.snowball.patsupport.utils;

import com.snowball.common.api.signature.impl.SnbSigMd5;
import com.snowball.patsupport.bean.KvSqBean;
import com.snowball.patsupport.bean.NewSqRequest;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.Date;

@Slf4j
public class CommonSpRequestUtil {

    private final static String MERCHANT_CODE = "80000005";
    private final static String SIGN_KEY = "2BFWS7GPFYQAJYRAGKHX2K648JNJPS45";
    private final static String SZT_SP_PREFIX_URL = "http://sztsp.shenzhentong.com:39045/proxy";

    /**
     * 执行批量请求
     * @param datas 数据
     * @param endPoint 请求地址节点
     */
    public static void exec(String[] datas, String endPoint) {
        String timeStamp = new Date().getTime() + "";
        KvSqBean request = null;
        for (int i = 0; i < datas.length; i++) {
            NewSqRequest req = JsonUtil.fromJson(datas[i],NewSqRequest.class);
            request = new KvSqBean();
            request.setData(datas[i]);
            request.setTimestamp(timeStamp);
            request.setMerchantCode(CommonSpRequestUtil.MERCHANT_CODE);
            request.setSign(CommonSpRequestUtil.getSign(datas[i],timeStamp + ""));
            String requestStr = JsonUtil.toJson(request, false);
            System.out.println(requestStr);
            try{
                String url = CommonSpRequestUtil.SZT_SP_PREFIX_URL + endPoint;
                log.info(url);
                CommonSpRequestUtil.sendRequest(req.getCardNo(), RequestBody.create(MediaType.parse("text/plain; charset=utf-8"),requestStr), url);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static String getSign(String data, String timeStamp){
        String signData = null;
        try {
            // 拼接参数生成签名 data+timestamp+merchantCode
            StringBuffer plainData = new StringBuffer().append(data).append(timeStamp).append(CommonSpRequestUtil.MERCHANT_CODE);
            signData = new SnbSigMd5().sign(plainData.toString(), SIGN_KEY, "UTF-8");
            System.out.println(signData);
        }catch (Exception e){
            e.printStackTrace();
        }
        return signData;
    }

    public static void sendRequest(String cardNo, RequestBody requestObj, String url) throws InterruptedException{
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(url)
                .post(requestObj)
                .build();
        Call call = okHttpClient.newCall(request);
        System.out.println(call);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                System.out.println(cardNo +" " + response.body().string());
            }
        });
    }
}
