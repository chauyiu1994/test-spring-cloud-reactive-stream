package com.chauyiu1994.testreactivestream;

import com.chauyiu1994.testreactivestream.messages.TextPlainMessageConverter;
import com.chauyiu1994.testreactivestream.model.LogMessage;
import com.chauyiu1994.testreactivestream.processor.MyProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.converter.CompositeMessageConverterFactory;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.stream.reactive.StreamEmitter;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.reactive.config.EnableWebFlux;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootApplication
@EnableBinding(MyProcessor.class)
@EnableWebFlux
public class MyLoggerServiceApplication {

    @Autowired
    private MyProcessor processor;

    public static void main(String[] args) {
        SpringApplication.run(MyLoggerServiceApplication.class, args);
    }

    @Bean
    public MessageConverter providesTextPlainMessageConverter() {
        return new TextPlainMessageConverter();
    }

    @Bean
    public CompositeMessageConverterFactory converterFactory() {
        return new CompositeMessageConverterFactory(
                Collections.<MessageConverter>emptyList(), null);
    }
    @EnableAutoConfiguration
    public static class HelloWorldEmitter {

        @StreamEmitter
        @Output(MyProcessor.OUTPUT)
        public Flux<String> emit() {
            return Flux.interval(Duration.ofSeconds(1))
                    .map(l -> "Hello World" + LocalDateTime.now());
        }
    }
}