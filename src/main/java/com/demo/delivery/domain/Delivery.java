package com.demo.delivery.domain;

import javax.persistence.Embedded;
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
    private Long id;                            // 배송ID

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;      // 배송상태

    private Long memberId;                      // 회원ID
    private String deliveryStartDt;             // 배송시작일자
    private String deliveryEndDt;               // 배송종료일자
    private String trackingNumber;              // 운송장번호
    private Long orderItemId;                   // 주문상품ID

    @Embedded
    private Courier courier;                    // 택배기사

    @OneToOne
    @JoinColumn(name="deliveryAddress_id")
    private DeliveryAddress deliveryAddress;    // 배송주소


    @PostPersist
    public void onPostPersist() {
        DeliveryCompleted deliveryCompleted = new DeliveryCompleted();
        deliveryCompleted.setId(this.id);
        deliveryCompleted.setMemberId(this.memberId);
        deliveryCompleted.setOrderItemId(this.orderItemId);
        deliveryCompleted.publishAfterCommit();
    }

}
