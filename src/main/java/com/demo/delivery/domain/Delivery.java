package com.demo.delivery.domain;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PostUpdate;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                            // 배송ID

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;      // 배송상태

    private Long memberId;                      // 회원ID
    private String deliveryStartDt;             // 배송시작일자
    private String deliveryEndDt;               // 배송종료일자
    private String trackingNumber;              // 운송장번호
    private Long ecoOrderId;                    // 주문ID
    private Long orderItemId;                   // 주문상품ID
    private String ecoProductName;              // 주문상품명(대표)

    @Embedded
    private Courier courier;                    // 택배기사

    @OneToOne
    @JoinColumn(name="deliveryAddress_id")
    private DeliveryAddress deliveryAddress;    // 배송주소


    @PostUpdate
    public void onPostUpdate() {
        if(this.deliveryStatus == DeliveryStatus.COMP) {

            DeliveryCompleted deliveryCompleted = new DeliveryCompleted();
            deliveryCompleted.setDeliveryId(this.id);
            deliveryCompleted.setMemberId(this.memberId);
            deliveryCompleted.setEcoOrderId(this.ecoOrderId);
            deliveryCompleted.setDeliveryStatus(this.deliveryStatus.toString());
            deliveryCompleted.setDeliveryStartDt(this.deliveryStartDt);
            deliveryCompleted.setDeliveryEndDt(this.deliveryEndDt);
            deliveryCompleted.publishAfterCommit();

        } else if(this.deliveryStatus == DeliveryStatus.SHIPPING) {

            DeliveryStarted deliveryStarted = new DeliveryStarted();
            deliveryStarted.setDeliveryId(this.id);
            deliveryStarted.setEcoOrderId(this.ecoOrderId);
            deliveryStarted.publishAfterCommit();
        }
    }

}
