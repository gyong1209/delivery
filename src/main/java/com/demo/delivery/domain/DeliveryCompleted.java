package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryCompleted extends AbstractEvent {

    private Long memberId;
    private Long deliveryId;
    private Long orderId;
    private String deliveryStatus;
    private String deliveryStartDt;
    private String deliveryEndDt;


}
