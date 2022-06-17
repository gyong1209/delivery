package com.demo.delivery.domain;

import com.demo.delivery.AbstractEvent;

public class PaymentCompleted extends AbstractEvent {
    
    private Long id;
    private String address;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }



}
