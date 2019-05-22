package com.dm.login.wxBean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@XStreamAlias("xml")
public class MusicMessage extends BaseMessage{

    private String mediaId;
    private String title;
    private String description;
    private String musicURL;
    private String hQMusicUrl;
    private String thumbMediaId;

    public MusicMessage(Map<String,String> requestMap, String mediaId, String title,
                        String description,String musicURL, String hQMusicUrl, String thumbMediaId){
        super(requestMap);
        this.setMsgType("music");
        this.mediaId = mediaId;
        this.title = title;
        this.description = description;
        this.musicURL = musicURL;
        this.hQMusicUrl = hQMusicUrl;
        this.thumbMediaId = thumbMediaId;
    }
}
