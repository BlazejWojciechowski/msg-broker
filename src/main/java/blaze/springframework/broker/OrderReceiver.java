package blaze.springframework.broker;

import blaze.springframework.broker.tacos.Order;
public interface OrderReceiver {
  Order receiveOrder();
}