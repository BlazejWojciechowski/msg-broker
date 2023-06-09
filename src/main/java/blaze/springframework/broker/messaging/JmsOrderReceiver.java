package blaze.springframework.broker.messaging;

import blaze.springframework.broker.OrderReceiver;
import blaze.springframework.broker.tacos.Order;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Profile("jms-template")
@Component("templateOrderReceiver")
public class JmsOrderReceiver implements OrderReceiver {
  private JmsTemplate jms;
  public JmsOrderReceiver(JmsTemplate jms) {
    this.jms = jms;
  }
  @Override
  public Order receiveOrder() {
    return (Order) jms.receiveAndConvert("tacocloud.order.queue");
  }
}