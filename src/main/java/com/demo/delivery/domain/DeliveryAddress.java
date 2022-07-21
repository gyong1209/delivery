package com.demo.delivery.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class DeliveryAddress {

    @Id @GeneratedValue
    private Long id;

    private String recipientName;
    private String deliveryPlace;
    private String basAddr;
    private String dtlAddr;
    private String extraAddr;
    private String zipcode;
    private String rootAddrYn;


}
