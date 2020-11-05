package com.snowball.patsupport.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Slf4j
public class AliyunLogUtil {

    private final static String LOG_URL = "https://sls.console.aliyun.com/console/logstoreindex/getLogs.json";
    // "OPkI2tN3uuNs3hdPhcJ9W9"
    private static final String  STORE_NAME = "pta-service-pd-logstore";
    private static final String PROJECT_NAME = "snb-k8s-log-prod-project";
//    private static final
    @Data
    static class RequestForm {
        private String LogStoreName;
        private String ProjectName;
        private String query;
        private long from;
        private long to;
        private int Page;
        private int Size;
        private boolean Reverse; //是否倒序
        private String secToken;

        public static RequestForm defaultRequestForm(String query){
            RequestForm form = new RequestForm();
            form.setLogStoreName(STORE_NAME);
            form.setProjectName(PROJECT_NAME);
            form.setPage(1);
            form.setSize(20);
            form.setQuery(query);
            long[] fromTo = DateUtil.oneWeek();//默认一周的时间
            form.setFrom(fromTo[0]);
            form.setTo(fromTo[1]);
            form.setReverse(true); //默认时间倒序
            form.setSecToken("NBBa1js4lEV9JNUuq5OQW4");
            return form;
        }
    }

    public static void main(String[] args) {
        RequestForm form = RequestForm.defaultRequestForm("479007644701F356060092620137114001584810000000510000043B198DAB1D80010000000000354552");
        log.info(JsonUtil.toJson(form, false));
        String cookies = "aliyun_choice=CN; cna=173lF+GQJ04CAXOrhkBGXF1+; aliyun_lang=zh; aliyun_site=CN; _bl_uid=pmkkdf0F1gCvbUyy8lCvijwhpadR; UM_distinctid=1748a790351733-0af9ee0e21fe32-316b7005-384000-1748a790352908; aliyun_country=CN; console_base_assets_version=3.16.2; pageSize=20; ONE_CONSOLE_NEW_JSESSIONID=49fd5de2-b5e4-4e0a-b116-35915f80405e; currentRegionId=cn-shanghai; activeRegionId=cn-shanghai; consoleNavVersion=1.4.116; _HOME_JSESSIONID=02666H71-NV8GLPT1XWH2RCC1SCQV1-X8MCO7GK-TK366; _home_session0=7TOQE%2F90JmkJdb949hF%2B50N4IHDqNJmAoAXir4IDyzMqUUmfhdVMwyuqKLKtQmlFV3MOQvERNJXtk77TudCfWYvvJsOPFhjWbLhT1%2BfxLg5d%2FhpVSd38Td4sRVu%2FcyQDPb8QSoP1GB9RzJePu0kDQ5BcCFmAj1uiW9VirTayKih4891ERRxKXz%2BHs22%2FOA7fKsw0pWRFhKvVBpE23hw0fSywDbzIfYfl9FlK4iDp13Ebm%2BU2iU%2FeH%2FyTOHtnShK76b8JOkQfb5NqioVu7sHb8bBsYn1VDUUcu8GZ18JWbgfKoKALNHhhzB9wWv2f4mKmoEjwywovNDfgWls5VGAHBw%3D%3D; xlly_s=1; login_aliyunid_csrf=c42d49df7c464a2e8a50adaecb3b0b92; login_aliyunid=\"demon.dong @ 1891530171838126\"; login_aliyunid_ticket=L5ybKIVO9ry1ixecSt4WxzWbrH7EqubLlnHGRbK9Zhcfq1S1E2ml6JYlY4q9CyLstMknfiSc2GhOwNcWzj5bYLpKzKZ49O80KpzxYXWJ0WPzFXDzr7rhZ_Dua5Qyv2KMv85szYAdhP4$; login_aliyunid_sc=74u48x24xL7xCj1SQ9*cYL0T_GM6j755Ey*9uMeSNM6v*vdOmtAmf_1nsG4X*a9X56CirX_*9VBpfkTFdJTd54lnGQ1xSW5T1vAZyoTUQ*frmJK*H1vT5ERPp2356A*R; JSESSIONID=1N5669C1-8B3KIBET3DF9A7JGKPB62-C7FR59GK-CEY; sls_console0=ylMm8g767LsfPlTeRTycxiNl8q0SYLm9sM9G9%2BNaeTHjvHZALDmM9k%2FhOR3cb0IH%2F9AoyANXj4yj8Q92NaQW81wImRjAxFgGUKbuSSgkiCh9rJ3MeT8VIBjZLA%2Bs3fUtRrMER3YUJTYQIcjXE%2B67svH2aXwNM5FgvsKGQSuGwojmSdTVIvA4zdMZzuecFv9nhPgXZBBl2cfrYxCzADrjGcTcuzPLNrRpPIPI2%2BGOy4S3%2FXQk9IVYnieKWVmUznv7t0Gd9nelag8Yf2gupJYuF2ohLthevYPYS09hDsYUZP8AmDVeyzv4gE7JPX%2F6NE0B; FECS-XSRF-TOKEN=4324818e-4ee2-45dd-8229-136e979876ba; FECS-UMID=%7B%22token%22%3A%22Y5bfde29a5af937ee7133dccf3184dd88%22%2C%22timestamp%22%3A%224988658355555148574C6D7E%22%7D; reverse=true; tfstk=c9F5BNDPRkFVrxBeaz_qzwa2PymACnKj8TgLP8KN7gPW61L-mB10GCosdWyHjIHtl; l=eBPoRGhPOzppWItwBO5Z-urza77T5LOjCsPzaNbMiInca1olcH7vqNQVa5fXFdtjgtfjgrxuRC1CkF43IUV0wxaGZIuCb-OWAxv9-; isg=BJCQY1R_-5WLIadJ9YXW_ZhtYdjiWXSjIldXhIpqN-uDxSVvvGHiM9iznY0lFSx7";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded"), JsonUtil.toJson(form,false));
        HttpRequestUtil.sendRequest(null, requestBody, LOG_URL, cookies);
    }

}
