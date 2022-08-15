package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentCompleted extends AbstractEvent {

    private Long id;
    private Long addressId;
    private Long memberId;
    private Long orderId;
    private String deliveryMessage;

}
