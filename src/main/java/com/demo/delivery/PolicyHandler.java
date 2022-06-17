package com.demo.delivery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import com.demo.delivery.kafka.KafkaProcessor;

import com.demo.delivery.domain.Delivery;
import com.demo.delivery.domain.DeliveryRepository;
import com.demo.delivery.domain.PaymentCompleted;

@Service
public class PolicyHandler {
    
    @Autowired
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCompleted(@Payload PaymentCompleted paymentCompleted){
        if(!paymentCompleted.validate())
            return;

        System.out.println("ddsfasdf");
        Delivery delivery = new Delivery();
        delivery.setAddress(paymentCompleted.getAddress());

        deliveryRepository.save(delivery);
    }

}
