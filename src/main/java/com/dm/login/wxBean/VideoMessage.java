package com.dm.login.wxBean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@XStreamAlias("xml")
public class VideoMessage extends BaseMessage{

    private String mediaId;
    private String title;
    private String description;

    public VideoMessage(Map<String,String> requestMap, String mediaId, String title,String description){
        super(requestMap);
        this.setMsgType("video");
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
    }
}
