package com.chauyiu1994.teststreamreceiver.teststreamreceiver;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
public class LogSubscribeHandler {
    @StreamListener(LogSubscribeChannel.SUBSCRIBE)
    public void handleSubscribe(String s) {
        System.out.println(s);
    }
}