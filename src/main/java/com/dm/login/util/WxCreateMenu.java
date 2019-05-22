package com.dm.login.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dm.login.wxBean.*;

import java.util.ArrayList;
import java.util.List;

public class WxCreateMenu {

    public static void main(String[] args) {
        createMenu();
    }

    public static void createMenu(){
        Button button = new Button();
        List<BasisButton> basisButtons = new ArrayList<>();
        basisButtons.add(new ClickButton("菜单DM","1"));
        basisButtons.add(new ViewButton("菜单二","http://www.baidu.com"));
        SubButton sb = new SubButton("二级菜单");
        sb.getSub_button().add(new ClickButton("点我啊","V1001_TODAY_MUSIC"));
        sb.getSub_button().add(new ClickButton("丹妹妹","V1001_TODAY_MUSIC"));
        basisButtons.add(sb);
        button.setButton(basisButtons);
        JSONObject json = (JSONObject) JSON.toJSON(button);

        System.out.println(WxService.getAccessToken());
        String url = "https://api.weixin.qq.com/cgi-bin/get_current_selfmenu_info?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN",WxService.getAccessToken());
        String result = WxUtil.post(url,json.toString());
        System.out.println(result);
    }

    public static void delMenu(){
        String url = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
        url = url.replace("ACCESS_TOKEN",WxService.getAccessToken());
        String result = WxUtil.post(url,null);
        System.out.println(result);
    }
}
