package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCanceled extends AbstractEvent {

  private Long id;
  private Long orderId;
  private Long memberId;
  private Long productId;
  private int price;
  private String paymentMethod;

}
