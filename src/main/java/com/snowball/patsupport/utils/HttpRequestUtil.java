package com.snowball.patsupport.utils;

import okhttp3.*;

import java.io.IOException;
import java.util.Map;

public class HttpRequestUtil {

    public static void sendRequest(String cardNo, RequestBody requestObj, String url) {
        sendRequest(cardNo, requestObj, url,null);
    }
    public static void sendRequest(String cardNo, RequestBody requestObj, String url, String cookies){
        System.out.println(url);
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request.Builder requestBuilder = new Request.Builder()
                .addHeader("accept", "application/json")
                .addHeader("refer", "https://sls.console.aliyun.com/next/project/snb-k8s-log-prod-project/logsearch/pta-service-pd-logstore?sls_iframe=true&hideTopbar=true&showEtl=true&hideSideBar=true&isShare=true&spm=5176.2020520112.0.0.138234c0p8VvGU&queryTimeType=2&initSearch=true")
                .url(url)
                .post(requestObj);
        if (cookies != null) {
            requestBuilder.addHeader("cookie",cookies);
        }
        Call call = okHttpClient.newCall(requestBuilder.build());
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
