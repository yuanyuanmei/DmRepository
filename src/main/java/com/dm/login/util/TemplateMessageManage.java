package com.dm.login.util;

import com.alibaba.fastjson.JSONObject;

public class TemplateMessageManage {

    public static void set(){
        String url = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN",WxService.getAccessToken());
        JSONObject data = new JSONObject();
        data.put("industry_id1","1");
        data.put("industry_id2","4");
        String result = WxUtil.post(url,data.toString());
        System.out.println(result);
    }

    public static void get(){
        String url = "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN",WxService.getAccessToken());
        String result = WxUtil.post(url,null);
        System.out.println(result);
    }


    public static void send(){
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN",WxService.getAccessToken());
        String data = "      {\n" +
                "           \"touser\":\"oCJSa1PQcUlz6SBpZNwgaUcUxRi0\",\n" +
                "           \"template_id\":\"shBsfkNMPYr1aqBi90TMT6k8i4DXV6rZiH_U3L9ZqKs\",\n" +
                "           \"url\":\"www.baidu.com\",  \n" +
                "           \"data\":{\n" +
                "                   \"first\": {\n" +
                "                       \"value\":\"简历通知！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword1\":{\n" +
                "                       \"value\":\"王功明\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword2\": {\n" +
                "                       \"value\":\"18573519914\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"keyword3\": {\n" +
                "                       \"value\":\"2019年5月17日\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   },\n" +
                "                   \"remark\":{\n" +
                "                       \"value\":\"加油负重前行！\",\n" +
                "                       \"color\":\"#173177\"\n" +
                "                   }\n" +
                "           }\n" +
                "       }";
        String result = WxUtil.post(url,data);
        System.out.println(result);
    }
}
