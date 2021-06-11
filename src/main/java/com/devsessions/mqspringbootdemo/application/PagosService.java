package com.devsessions.mqspringbootdemo.application;

import com.ibm.mq.jms.MQQueue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import java.util.Random;

@Slf4j
@Service
public class PagosService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @JmsListener(destination = "DEV.QUEUE.1")
    public void validarPagos(Message message) throws JMSException {
        TextMessage textMessage = (TextMessage) message;
        final String textMessageBody = textMessage.getText();
        log.info("------**** Pago recibido ***----------{}",textMessageBody);

        log.info("----**** PROCESANDO **** -------");
        Random random = new Random();
        String pagoProcesado ="PAGO_EXITOSO";
        if((random.nextInt(10)>=5))
            pagoProcesado ="PAGO_FALLIDO";

        log.info("Resultado pago procesado {}",pagoProcesado);

        // Ingesar a BD, enviar a otra cola etc...

    }
}
