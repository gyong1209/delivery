package com.demo.delivery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 배송주소ID

    private Long memberId;          // 회원ID
    private String recipientName;   // 받는분
    private String deliveryPlace;   // 배송지명
    private String basAddr;         // 도로명(지번)주소
    private String dtlAddr;         // 상세주소
    private String extraAddr;       // 참고항목
    private String zipcode;         // 우편번호
    private String rootAddrYn;      // 기본배송지여부


}
