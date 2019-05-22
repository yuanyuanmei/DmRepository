package com.dm.login.servlet;

import com.dm.login.util.WxService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 快捷键实现接口方法
 * alt+insert
 */
@Slf4j
public class WxServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    public WxServlet(){
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * signature	微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
         * timestamp	时间戳
         * nonce	    随机数
         * echostr	    随机字符串
         */
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        if(WxService.check(timestamp,nonce,signature)){
            log.info("接入通过");
            PrintWriter out = response.getWriter();
            out.print(echostr);
            out.flush();
            out.close();
        }else{
            log.info("接入失败");
        }


    }

    /**
     * 发送消息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        log.info("post请求成功");
        Map<String,String> requestMap = WxService.parseRequest(request.getInputStream());
        log.info(requestMap.toString());
        //准备回复的数据包
        String respXml = WxService.getResponse(requestMap);
        System.out.println(respXml);
        PrintWriter out = response.getWriter();
        out.print(respXml);
        out.flush();
        out.close();





    }
}
