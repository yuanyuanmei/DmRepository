package com.dm.login.util;

import com.alibaba.fastjson.JSONObject;
import com.dm.login.wxBean.*;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class WxService {

    private static final String TOKEN = "wxdm123";

    private static final String GET_TOKEN_URL="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    private static final String APPID = "wx47a476f2496eb407";

    private static final String APPSECRET = "d6aeaa7538aa154912f4c702c26e198e";

    private static AccessToken at ;
    /**
     * 获取token
     */
    private static void getToken(){
        String url = GET_TOKEN_URL.replace("APPID",APPID).replace("APPSECRET",APPSECRET);
        String strToken = WxUtil.get(url);
        JSONObject jsonObject =  JSONObject.parseObject(strToken);
        String token = jsonObject.getString("access_token");
        String expires_in = jsonObject.getString("expires_in");
        //创建token对象
        at = new AccessToken(token,expires_in);
    }

    /**
     * 外界获取token方法
     * @return
     */
    public static String getAccessToken(){
        if(at==null||at.isExpired()){
            getToken();
        }
        return at.getAccessToken();
    }

    /**
     * 验证签名
     * @param signature
     * @param timestamp
     * @param nonce
     * @return
     */
    public static boolean check(String timestamp,String nonce,String signature){
        //TODO  1.将token、timestamp、nonce三个参数进行字典序排序
        String[] strs = new String[]{TOKEN,timestamp,nonce};
        Arrays.sort(strs);
        //TODO 2.将三个参数字符串拼接成一个字符串进行sha1加密
        String str = strs[0] + strs[1] + strs[2];
        String mysig = sha1(str);
        //TODO 3.开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        return mysig.equalsIgnoreCase(signature);
    }

    /**
     * 进行sha1加密
     * @param str
     * @return
     */

    public static String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static Map<String,String> parseRequest(InputStream is){
        Map<String,String> map = new HashMap<>();
        SAXReader reader = new SAXReader();
        try {
            //读取输入流，获取文档对象
            Document document = reader.read(is);
            //根据文档对象获取节点
            Element root = document.getRootElement();
            //获取节点的所有子节点
            List<Element> elements = root.elements();
            for(Element e:elements){
                map.put(e.getName(),e.getStringValue());
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static String getResponse(Map<String,String> requestMap){
        BaseMessage msg = null;
        String msgType = requestMap.get("MsgType");
        System.out.println("msgType为："+msgType);
        switch (msgType){
            case "text":
                msg = dealTextMessage(requestMap);
                break;
            case "image":
                break;
            case "voice":
                break;
            case "video":
                break;
            case "shortvideo":
                break;
            case "event":
                msg = dealEventMessage(requestMap);
                break;
            default:
                break;
        }
        if(msg != null){
            return beanToXml(msg);
        }
        return null;
    }

    private static BaseMessage dealEventMessage(Map<String, String> requestMap) {
        String event = requestMap.get("Event");
        System.out.println(event);
        switch (event){
            case "CLICK":
                return dealClick(requestMap);
            case "VIEW":
                return null;
            default:
                return null;
        }

    }

    private static BaseMessage dealClick(Map<String, String> requestMap) {
        String key = requestMap.get("EventKey");
        switch (key){
            case "1":
                System.out.println("进来了没");
                return new TextMessage(requestMap,"点击了一级菜单");
            default:
                break;

        }
        return null;
    }


    private static String beanToXml(BaseMessage msg) {
        XStream stream = new XStream();
        stream.processAnnotations(TextMessage.class);
        stream.processAnnotations(ImageMessage.class);
        stream.processAnnotations(MusicMessage.class);
        stream.processAnnotations(NewsMessage.class);
        stream.processAnnotations(VideoMessage.class);
        stream.processAnnotations(VoiceMessage.class);
        return stream.toXML(msg);
    }

    private static BaseMessage dealTextMessage(Map<String, String> requestMap) {
        String content = requestMap.get("Content");
        BaseMessage message = null;
        if(content.equals("图文消息")){
            List<ArticleBean> articles = new ArrayList<>();
            ArticleBean articleBean = new ArticleBean("丹妹照片","是月光在流浪",
                    "http://mmbiz.qpic.cn/mmbiz_jpg/TIM8aibaf3IiciaibuWzjstpEFoYibWr5L4Nhic1ms9ib6ZCwnTFu58FFtOwrm7W0niaeWIguVrggOT2tDTC9MQhb8HVDQ/0","www.baidu.com");
            articles.add(articleBean);
            message = new NewsMessage(requestMap,articles);
        }else{
            message = new TextMessage(requestMap,"丹妹");
        }

        return message;
    }


}
