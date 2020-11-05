package com.snowball.patsupport.utils;

import okhttp3.*;

import java.io.IOException;

/**
 * 阿里ACM配置工具类
 * 可以精准查询日志,查询数据库,查看ACM配置
 */
public class AliAcmUtil {

    //登录用户名
    private final static String LOGIN_USER = "demon.dong@1891530171838126.onaliyun.com";

    //登录密码
    private final static String LOGIN_PASSWORD = "GlQHBItix56t2JuaHnAP1vs|ycZ%J)%W";

    //登录地址
    private final static String LOGIN_URL = "https://signin.aliyun.com/login.htm?spm=5176.12901015.yrepazatz.6.53f0525c2lnpqB&callback=";

    private final static String COOKIE = "aliyun_choice=CN; cna=173lF+GQJ04CAXOrhkBGXF1+; ping_test=true; t=54a4c896ee35b1af64339223b794befe; _tb_token_=e1d0b33a8eae3; cookie2=14d56e60dc7aa0cdb572c8adfc8fd93c; _samesite_flag_=true; aliyun_lang=zh; aliyun_site=CN; _bl_uid=pmkkdf0F1gCvbUyy8lCvijwhpadR; pageSize=20; UM_distinctid=1748a790351733-0af9ee0e21fe32-316b7005-384000-1748a790352908; aliyun_country=CN; consoleNavVersion=1.4.116; console_base_assets_version=3.16.2; COS_JSESSIONID=EN566OA1-DWAJOHQHYZ0YP2P9HVSB3-NCH2CFFK-N0T; _cos_session0=orJa10GffQHIP%2BFIxHWw2jFF549aKB%2Fnc3Qo1XUte9vDHunlnUU%2BnTiEdWvzbInVO2LqDP6ClRRYd59fNndcLfYCRtKnykDY8ynsmViP80wekGFR8TG3IHkWKmihA0p195l64mswcDY3R2PFC5L%2BSirYEIkOJGfiiyIMN2ne3pB7wNWknqWzpIPrRqvsLENxAH51ODydSCPPv8Av2mnd%2FCuBGqX1RdNSvjGO0VoQzaaEZPPRjhPyNaimleuzYzyHNHWm%2FQfdHE89KjX9vJUPFCUSaMS%2FxvOj9pEhixKjd1aGmR0n366SNXrEhKiTIoar; UC-XSRF-TOKEN=8bf09064-0631-41f7-b811-8dfc09109e98; ONE_CONSOLE_NEW_JSESSIONID=9dce5fd9-178f-4043-b5ef-e403ad2be676; _one_console_new_session0=OQRknb2AL9wLSZUAUJwjD5gy%2B9BkdKmGgZaNg%2BpMgXXvKQSc3VqtWd15vBgYkKS%2BJh%2FItB7PSnnH5SqYzPZhL8aAjY%2Fc0Z7g%2By%2BtYwXoaDr24cnxc2MKZYCL4UUdjfNAiVcI63TNVe3fI%2BpsHjzxvYImfDTJ3OWE9A7EnfgWQkR4Jrk6rDHuudD2Nflsgc7bFC7cIU9KljUl0%2FEnckfRS%2F1aV0uHhAoPd2qCyZBQ5Ntkh1%2FuuE1un0X4XMZbWf5cCg0obNusGAS%2B7aYEPd9u2X2PwqhHE91PJm6km%2BviiMEnhRe%2F8itdUPHqlQ4Kbz%2FbyokYfQyD31cfx0TGLEbGstXvt4LnPpg4iJYxZKuBpTM%3D; _HOME_JSESSIONID=P1666H81-4X8G821I0J4H86EZSMOV3-08LSPGFK-LS8F5; _home_session0=Wpm%2Fx5dGmyijB%2FhTaQKfkj%2BSr9abK0Jd9Qze6%2F8pQETfinZxXt%2BSk29oglrZEAfP7U0dNFv7dXliNFNHXu0QP%2Bi%2F45ZuoVwTwQqWlbFuoN%2FsccwlfsqIbMzJ9J5Ff70vmUg2OYX0DFVP2YCZzzhqaQKK30u%2FL%2Bos4glv2YCuQ6LL2nr5UZYJSc1PUFPEovYEztzFVsgodRHa2o8G6zKzKdlSx5PklPdKY%2BVJ37ta1C0%2BHlZBCKXwAEMvRPNXqvzet3%2BiKCVmTUn%2BTAL4ji%2BYCO91julyjgWI0nWkW9QR7t1BSoWC9xpiW6HhDzTj%2FcPE; reverse=false; xlly_s=1; login_aliyunid_csrf=aa518cadcfcb403c96b3d2bd3c487cc7; login_aliyunid=\"demon.dong @ 1891530171838126\"; login_aliyunid_ticket=L5ybKIVO9ry1ixecSt4Wx8dtUWYgm9n3g0mc9O0T3sgfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755Ey*9uMeSNM6v*vdOmtAmf_1nsG4X*a9X56CirX_*9VBpfkTFdJTd5wkO5dKoHjWfNrc1gnDo3YnrmJK*H1vT5ERPp2356A*R; FECS-XSRF-TOKEN=f14f3146-dc67-4792-8a5b-cfdd6cd7c0bd; FECS-UMID=%7B%22token%22%3A%22Y8b7f902bc2736e53ddcf07ddcebc4b6e%22%2C%22timestamp%22%3A%220969106151555F495049637C%22%7D; currentRegionId=public; activeRegionId=public; JSESSIONID=0N566091-BYLJ28WCWAIMI2XBCOQQ3-OZ0SHKFK-9SK; sls_console0=rmdxVtdA7yI5%2FFXt%2BNtKhtMiiT27r7jB5Ke0gveylLEXqf8jseZWr1JS0RTpbUnq4G%2BVEKDtVE%2F2N4SNooq6%2BjOJKLAG6%2Fiy%2Bmrl6cCQE87JmnFzpfrWbicT9%2BMpVUTB1clIvsN99JH0J%2FLw%2FMS9YN6619%2FtRM3qnhkkaXDQ3fd8obsPkpsAiLqoNWLcB%2ByYHdEemcarnsh8FZ31ftAQWJJEbYL7r%2F5jaXQ%2BigdMCbrYvuOrt4J2xWyqaWpSx0j%2BqSQep%2BO9bE9WJ2ypEWtxvXkuA7fe3gJ5vyq5nzGJkUAfEew0dHYNbCNPu3ZHPXFH; tfstk=cXIlB7sHoIG_C88c5ut5Cmx8rwNOavcpsw7c0i0Nc1f6_RjXUscxuVyNgSA5ZM3C.; l=eBPoRGhPOzppWuevBO5CFurza77OrIRbzdVzaNbMiInca6G51FsKONQ4xTNkRdtjgtfFK3tr53kpSRevJgzNw0RpDtQX_hiDnxJwO; isg=BMXFNGVGNivJLBLG-A4rio3W1Af_gnkUh-mmsMcqQfwaXufQl9Im5BN4aIKoN5HM";

    static {

    }

    private static String login() {
            String url = "https://signin.aliyun.com/federation?action=GetUserRealm&user=demon.dong%401891530171838126.onaliyun.com&callback=https%3A%2F%2Fhomenew.console.aliyun.com%2F";
            OkHttpClient okHttpClient = new OkHttpClient();
            final Request request = new Request.Builder()
                    .url(url)
                    .build();
            Call call = okHttpClient.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }
                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    //
                }
            });
        return null;
    }

    public static void main(String[] args) {
        AliAcmUtil.login();
    }

    public static String getCookie(){
        return AliAcmUtil.COOKIE;
    }

}
