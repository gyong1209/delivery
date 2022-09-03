package com.demo.delivery.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "with-writer", types = {Delivery.class})
interface WithWriterProjection {
    String getDeliveryStatus();
    String getDeliveryStartDt();
    String getDeliveryEndDt();
    String getTrackingNumber();
    String getMemberId();
    String getOrderId();
    DeliveryAddress getDeliveryAddress();
}
