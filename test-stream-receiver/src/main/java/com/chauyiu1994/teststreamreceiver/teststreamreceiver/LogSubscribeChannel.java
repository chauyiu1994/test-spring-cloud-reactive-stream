package com.chauyiu1994.teststreamreceiver.teststreamreceiver;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
public interface LogSubscribeChannel {
    String SUBSCRIBE = "subscribe";

    @Input(SUBSCRIBE)
    SubscribableChannel subscribe();
}