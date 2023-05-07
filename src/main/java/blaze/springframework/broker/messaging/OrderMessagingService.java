package blaze.springframework.broker.messaging;

import blaze.springframework.broker.tacos.Order;
public interface OrderMessagingService {
  void sendOrder(Order order);
}