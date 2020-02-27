package com.chauyiu1994.teststreamreceiver.teststreamreceiver;

import com.rabbitmq.client.Consumer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.converter.CompositeMessageConverterFactory;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;
import reactor.core.publisher.Flux;

import java.util.Collections;

@SpringBootApplication
@EnableBinding({
        LogSubscribeChannel.class
})
public class TeststreamreceiverApplication {

    public static void main(String[] args) {
        SpringApplication.run(TeststreamreceiverApplication.class, args);
    }

    @Bean
    public CompositeMessageConverterFactory converterFactory() {
        return new CompositeMessageConverterFactory(
                Collections.<MessageConverter>emptyList(), null);
    }

//    @EnableAutoConfiguration
//    public static class Processor1 {
//
//        @StreamListener(LogSubscribeChannel.SUBSCRIBE)
//        public void receive(String input) {
//            System.out.println("processor1: " + input);
//        }
//    }
}
