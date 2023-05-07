package blaze.springframework.broker.messaging;

import blaze.springframework.broker.OrderReceiver;
import blaze.springframework.broker.tacos.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("rabbitmq-template")
@Component("templateOrderReceiver")
public class RabbitOrderReceiver implements OrderReceiver {
  private RabbitTemplate rabbit;
  public RabbitOrderReceiver(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }
  public Order receiveOrder() {
    return (Order) rabbit.receiveAndConvert("tacocloud.order.queue");
  }
}