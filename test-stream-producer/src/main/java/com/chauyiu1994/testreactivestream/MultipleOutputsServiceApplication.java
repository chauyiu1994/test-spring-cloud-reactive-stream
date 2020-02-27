package com.chauyiu1994.testreactivestream;

import com.chauyiu1994.testreactivestream.processor.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@SpringBootApplication
@EnableBinding(MyProcessor.class)
public class MultipleOutputsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultipleOutputsServiceApplication.class, args);
    }

    @Autowired
    private MyProcessor processor;

    @StreamListener(MyProcessor.INPUT)
    public void routeValues(Integer val) {
        if (val < 10) {
            processor.anOutput()
                    .send(message(val));
        } else {
            processor.anotherOutput()
                    .send(message(val));
        }
    }

    private static final <T> Message<T> message(T val) {
        return MessageBuilder.withPayload(val)
                .build();
    }
}