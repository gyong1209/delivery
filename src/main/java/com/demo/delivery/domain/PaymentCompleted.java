package com.demo.delivery.domain;

import java.util.List;

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
    private Long orderItemId;
    private String deliveryMessage;
    private int price;
    private String paymentMethod;
    private String orderDate;

    // private List<OderItem> orderItems;


}
