package blaze.springframework.broker;

import blaze.springframework.broker.tacos.Order;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class KitchenUI {
  public void displayOrder(Order order) {
    log.info("RECEIVED ORDER:  " + order);
  }
}