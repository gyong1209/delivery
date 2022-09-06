package com.demo.delivery.domain;

import java.util.ArrayList;
import java.util.List;

import com.demo.delivery.AbstractEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCanceled extends AbstractEvent {

  private Long id;
  private Long memberId;
  private Long ecoOrderId;
  private int totalPrice;
  private String paymentMethod;
  private List<EcoOrderItem> orderItem = new ArrayList<>();

}
