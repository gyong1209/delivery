package com.demo.delivery.domain;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "with-address", types = {DeliveryAddress.class})
interface WithAddressProjection {
  String getRecipientName();
  String getDeliveryPlace();
  String getBasAddr();
  String getDtlAddr();
  String getExtraAddr();
  String getZipcode();
  String getRootAddrYn();
  String getMemberId();
  String getId();
}
