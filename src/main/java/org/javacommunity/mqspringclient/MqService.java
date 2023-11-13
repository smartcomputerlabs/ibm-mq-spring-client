package org.javacommunity.mqspringclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableJms
public class MqService {
    @Autowired
    private JmsTemplate jmsTemplate;

    @RequestMapping("send")
    private String sendMessage(){
        try{
            jmsTemplate.convertAndSend("","hello ms");
            return "OK";
        }catch(JmsException e){
            e.printStackTrace();
            return "fail";
        }
    }

}
