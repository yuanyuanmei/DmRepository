package com.dm.login.wxBean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@XStreamAlias("xml")
public class ImageMessage extends BaseMessage{

    private String mediaId;
    public ImageMessage(Map<String,String> requestMap, String mediaId){
        super(requestMap);
        this.setMsgType("image");
        this.mediaId = mediaId;
    }
}
