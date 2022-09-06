package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryStarted extends AbstractEvent {

  private Long deliveryId;
  private Long orderId;
}
