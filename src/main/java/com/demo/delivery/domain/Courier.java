package com.demo.delivery.domain;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Courier {

    private String courierName;   // 택배기사명
    private String companyName;   // 택배회사명

}
