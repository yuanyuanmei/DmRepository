package com.dm.login.wxBean;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@ToString
@XStreamAlias("xml")
public class NewsMessage extends BaseMessage{
    @XStreamAlias("ArticleCount")
    private String articleCount;
    @XStreamAlias("Articles")
    private List<ArticleBean> articles = new ArrayList<>();

    public NewsMessage(Map<String,String> requestMap, List<ArticleBean> articles){
        super(requestMap);
        this.setMsgType("news");
        this.articleCount = articles.size()+"";
        this.articles = articles;

    }
}
