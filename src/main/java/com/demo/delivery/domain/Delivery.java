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

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
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

}
