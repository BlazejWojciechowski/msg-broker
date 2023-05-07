package blaze.springframework.broker.messaging;

import blaze.springframework.broker.tacos.Order;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitOrderMessagingService implements OrderMessagingService {
  private RabbitTemplate rabbit;
  @Autowired
  public RabbitOrderMessagingService(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }
  public void sendOrder(Order order) {
    rabbit.convertAndSend("tacocloud.order.queue", order,
            message -> {
              MessageProperties props = message.getMessageProperties();
              props.setHeader("X_ORDER_SOURCE", "WEB");
              return message;
            });
  }
}