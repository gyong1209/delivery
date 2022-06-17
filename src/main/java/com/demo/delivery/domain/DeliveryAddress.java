package com.demo.delivery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DeliveryAddress {

    @Id @GeneratedValue
    private Long id;

    private String recipientName;
    private String deliveryPlace;
    private String basAddr;
    private String dtlAddr;
    private String zipcode;

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRecipientName() {
        return recipientName;
    }
    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }
    public String getDeliveryPlace() {
        return deliveryPlace;
    }
    public void setDeliveryPlace(String deliveryPlace) {
        this.deliveryPlace = deliveryPlace;
    }
    public String getBasAddr() {
        return basAddr;
    }
    public void setBasAddr(String basAddr) {
        this.basAddr = basAddr;
    }
    public String getDtlAddr() {
        return dtlAddr;
    }
    public void setDtlAddr(String dtlAddr) {
        this.dtlAddr = dtlAddr;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    
}
