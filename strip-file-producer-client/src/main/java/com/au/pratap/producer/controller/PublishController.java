package com.au.pratap.producer.controller;


import com.au.pratap.model.StripFileTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
/**
 * @author Pratap
 */
@RestController
public class PublishController {
    protected int numberOfMessages = 100;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Bean
    public MessageConverter messageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody StripFileTransaction systemMessage) {
        try {
            for (int i = 0; i < numberOfMessages; ++i) {
                final int count = i;
                StripFileTransaction person = new StripFileTransaction("MessageCode"+count, "MessageText"+count, "333333"+count, "1472523"+count, "5345345"+count);
                jmsTemplate.convertAndSend("person-queue", person);
            }

            return new ResponseEntity<>("Sent.", HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
