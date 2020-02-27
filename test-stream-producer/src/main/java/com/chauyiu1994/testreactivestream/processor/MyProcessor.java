package com.chauyiu1994.testreactivestream.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyProcessor {
    String INPUT = "myInput";
    String OUTPUT = "output";
    String ANOTHER_OUTPUT = "anotherOutput";

    @Input
    SubscribableChannel myInput();

    @Output(OUTPUT)
    MessageChannel anOutput();

    @Output(ANOTHER_OUTPUT)
    MessageChannel anotherOutput();
}