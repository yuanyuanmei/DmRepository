package com.dm.login.wxBean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.Map;

@Data
@ToString
@XStreamAlias("xml")
public class TextMessage extends BaseMessage {

    @XStreamAlias("Content")
    private String content;

    public TextMessage(Map<String,String> requestMap,String content){
        super(requestMap);
        this.setMsgType("text");
        this.content = content;
    }
}
