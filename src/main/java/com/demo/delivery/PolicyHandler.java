package com.demo.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.delivery.kafka.KafkaProcessor;

import com.demo.delivery.domain.Delivery;
import com.demo.delivery.domain.DeliveryAddress;
import com.demo.delivery.domain.DeliveryAddressRepository;
import com.demo.delivery.domain.DeliveryRepository;
import com.demo.delivery.domain.PaymentCompleted;

@Service
public class PolicyHandler {

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    DeliveryAddressRepository deliveryAddressRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCompleted(@Payload PaymentCompleted paymentCompleted){
        if(!paymentCompleted.validate())
            return;

        DeliveryAddress deliveryAddress = deliveryAddressRepository.getOne(paymentCompleted.getAddressId());

        Delivery delivery = new Delivery();
        delivery.setDeliveryAddress(deliveryAddress);

        deliveryRepository.save(delivery);
    }

}
