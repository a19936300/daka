package com.binbinxiu.daka;

import cn.hutool.core.util.StrUtil;
import com.binbinxiu.daka.service.MessageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.xmlmessage.XMLMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.support.ExpireKey;
import weixin.popular.support.expirekey.DefaultExpireKey;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

@RestController
public class ReceiveServlet {

    @Autowired
    private MessageHandler messageHandler;

    //重复通知过滤
    private static ExpireKey expireKey = new DefaultExpireKey();
    //从官方获取
    private String token = "aihuapibinbinxiu";

    @GetMapping
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletOutputStream outputStream = response.getOutputStream();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        //首次请求申请验证,返回echostr
        if (echostr != null) {
            outputStreamWrite(outputStream, echostr);
            return;
        }

        //验证请求签名
        if (!signature.equals(SignatureUtil.generateEventMessageSignature(token, timestamp, nonce))) {
            System.out.println("The request signature is invalid");
            return;
        } else {
            outputStreamWrite(outputStream, echostr);
            return;
        }
    }

    @PostMapping
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        ServletOutputStream outputStream = response.getOutputStream();
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");

        //首次请求申请验证,返回echostr
        if (echostr != null) {
            outputStreamWrite(outputStream, echostr);
            return;
        }

        //验证请求签名
        if (!signature.equals(SignatureUtil.generateEventMessageSignature(token, timestamp, nonce))) {
            System.out.println("The request signature is invalid");
            return;
        }

        if (inputStream != null) {
            //转换XML
            EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class, inputStream);
            String key = eventMessage.getFromUserName() + "__"
                    + eventMessage.getToUserName() + "__"
                    + eventMessage.getMsgId() + "__"
                    + eventMessage.getCreateTime();
            if (expireKey.exists(key)) {
                //重复通知不作处理
                return;
            } else {
                expireKey.add(key);
            }

            //是否需要特殊处理的消息
            String resContent = messageHandler.handler(eventMessage);

            if(StrUtil.isNotBlank(resContent)){
                //创建回复
                XMLMessage xmlTextMessage = new XMLTextMessage(
                        eventMessage.getFromUserName(),
                        eventMessage.getToUserName(),
                        resContent);
                //回复
                xmlTextMessage.outputStreamWrite(outputStream);
                return;
            }

            //创建回复
            XMLMessage xmlTextMessage = new XMLTextMessage(
                    eventMessage.getFromUserName(),
                    eventMessage.getToUserName(),
                    "你好");
            //回复
            xmlTextMessage.outputStreamWrite(outputStream);
            return;
        }
        outputStreamWrite(outputStream, "");
    }

    /**
     * 数据流输出
     */
    private boolean outputStreamWrite(OutputStream outputStream, String text) {
        try {
            outputStream.write(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
