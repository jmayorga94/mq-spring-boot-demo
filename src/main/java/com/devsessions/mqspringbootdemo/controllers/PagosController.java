package com.devsessions.mqspringbootdemo.controllers;

import com.devsessions.mqspringbootdemo.dtos.EnviarPagoDto;
import com.ibm.mq.jms.MQQueue;
import com.ibm.msg.client.jms.internal.JmsTextMessageImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.*;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@RestController
@RequestMapping("pagos")
public class PagosController {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostMapping("enviar")
    public ResponseEntity enviarPago(@RequestBody EnviarPagoDto request) throws JMSException {

        MQQueue pagosRequestQueue = new MQQueue("DEV.QUEUE.1");
        String message = request.toString();
        try{
            jmsTemplate.convertAndSend(pagosRequestQueue,message, textMessage ->{
                textMessage.setJMSCorrelationID(request.getIdentificador());
                return textMessage;
            });
            return new ResponseEntity(request, HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR );
        }


    }
}
