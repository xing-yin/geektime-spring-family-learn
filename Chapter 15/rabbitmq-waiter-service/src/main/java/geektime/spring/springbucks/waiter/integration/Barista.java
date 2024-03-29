package geektime.spring.springbucks.waiter.integration;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface Barista {
    String NEW_ORDERS = "newOrders";
    String FINISHED_ORDERS = "finishedOrders";

    @Input
    SubscribableChannel finishedOrders();

    /**
     * 消息发送
     * @return
     */
    @Output
    MessageChannel newOrders();
}
