package com.demo.delivery.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostPersist;

@Entity
public class Delivery {

    @Id @GeneratedValue
    private Long id;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private Date startDate;
    private Date endDate;

    private Long orderItemId;

    @OneToOne
    @JoinColumn(name="deliveryAddress_id")
    private DeliveryAddress deliveryAddress;

    private String trackingNumber;
    private String deliveryMan;


    @PostPersist
    public void onPostPersist() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted();
        deliveryCompleted.setId(this.id);
        deliveryCompleted.setOrderItemId(this.orderItemId);
        deliveryCompleted.publishAfterCommit();
    }


    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }
    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    public Date getStartDate() {
        return startDate;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Date getEndDate() {
        return endDate;
    }
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Long getOrderItemId() {
        return orderItemId;
    }
    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }
    public DeliveryAddress getDeliveryAddress() {
        return deliveryAddress;
    }
    public void setDeliveryAddress(DeliveryAddress deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
    public String getTrackingNumber() {
        return trackingNumber;
    }
    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
    public String getDeliveryMan() {
        return deliveryMan;
    }
    public void setDeliveryMan(String deliveryMan) {
        this.deliveryMan = deliveryMan;
    }



}
