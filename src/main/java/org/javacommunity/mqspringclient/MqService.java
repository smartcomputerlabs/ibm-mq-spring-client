package org.javacommunity.mqspringclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
   @RequestMapping(path="test", produces= MediaType.TEXT_PLAIN_VALUE)
   public String test(){
       System.out.println("Restful");
       return "My First Restful Service Is Working";
   }
}
