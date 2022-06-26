package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderItemId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

}
