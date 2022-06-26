package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

public class PaymentCompleted extends AbstractEvent {

    private Long id;
    private Long addressId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getAddressId() {
        return addressId;
    }
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }



}
