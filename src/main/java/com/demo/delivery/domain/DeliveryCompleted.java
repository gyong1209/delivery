package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long memberId;
    private Long orderItemId;
    private String deliveryStatus;

}
