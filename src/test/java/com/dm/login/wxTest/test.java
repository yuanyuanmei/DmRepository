package com.dm.login.wxTest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dm.login.util.WxService;
import com.dm.login.wxBean.*;
import com.thoughtworks.xstream.XStream;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test {

    @Test
    public void test1(){
        Map<String,String> map = new HashMap<>();
        map.put("toUserName","toUserName");
        map.put("fromUserName","fromUserName");
        TextMessage tm = new TextMessage(map,"dm");
        XStream stream = new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        String xml = stream.toXML(tm);
        System.out.println(xml);
        /**
         * {"button":
         *      [
         *       {"name":"菜单一","type":"click","key":"V1001_TODAY_MUSIC"},
         *       {"name":"菜单二","type":"view","url":"www.baidu.com"},
         *      {"name":"二级菜单","sub_button":
         *      [{"name":"点我啊","type":"click","key":"V1001_TODAY_MUSIC"},
         *      {"name":"丹妹妹","type":"click","key":"V1001_TODAY_MUSIC"}
         *      ]}]}
         */
    }
    @Test
    public void test2(){
        Button button = new Button();
        List<BasisButton> basisButtons = new ArrayList<>();
        basisButtons.add(new ClickButton("菜单一","V1001_TODAY_MUSIC"));
        basisButtons.add(new ViewButton("菜单二","http://www.baidu.com"));
        SubButton sb = new SubButton("二级菜单");
        sb.getSub_button().add(new ClickButton("点我啊","V1001_TODAY_MUSIC"));
        sb.getSub_button().add(new ClickButton("丹妹妹","V1001_TODAY_MUSIC"));
        basisButtons.add(sb);
        button.setButton(basisButtons);
        JSONObject json = (JSONObject) JSON.toJSON(button);
        System.out.println(json.toString());
        System.out.println(WxService.getAccessToken());
    }
}
