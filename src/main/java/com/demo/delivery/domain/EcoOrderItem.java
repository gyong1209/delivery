package com.demo.delivery.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EcoOrderItem {

    private Long ecoProductId;
    private String ecoProductName;
    private int ecoProductUnitPrice;
    private int ecoProductQty;

}
