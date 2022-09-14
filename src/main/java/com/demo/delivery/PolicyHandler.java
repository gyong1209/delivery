package com.demo.delivery;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.delivery.kafka.KafkaProcessor;
import com.demo.delivery.domain.Courier;
import com.demo.delivery.domain.Delivery;
import com.demo.delivery.domain.DeliveryAddress;
import com.demo.delivery.domain.DeliveryAddressRepository;
import com.demo.delivery.domain.DeliveryRepository;
import com.demo.delivery.domain.DeliveryStatus;
import com.demo.delivery.domain.PaymentCanceled;
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

        // 배송기사 생성
        Courier courier = new Courier("김XX", "A택배");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        // 배송 생성
        Delivery delivery = new Delivery();
        delivery.setDeliveryAddress(deliveryAddress);
        delivery.setTrackingNumber(generateTrackingnumber());
        delivery.setCourier(courier);
        delivery.setEcoOrderId(paymentCompleted.getEcoOrderId());
        delivery.setMemberId(paymentCompleted.getMemberId());
        delivery.setDeliveryStatus(DeliveryStatus.READY);
        delivery.setDeliveryStartDt(LocalDate.now().format(formatter));
        delivery.setEcoProductName(paymentCompleted.getOrderItem().get(0).getEcoProductName());
        deliveryRepository.save(delivery);

    }

    @Transactional
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverPaymentCanceled(@Payload PaymentCanceled paymentCanceled){
        if(!paymentCanceled.validate())
            return;

        // 배송상태 확인 - '배송중' 또는 '배송완료' 상태일 경우, '배송진행됨' 이벤트 발행
        Delivery delivery = deliveryRepository.findByEcoOrderId(paymentCanceled.getEcoOrderId()).get(0);
        if(delivery.getDeliveryStatus().equals(DeliveryStatus.SHIPPING) || delivery.getDeliveryStatus().equals(DeliveryStatus.COMP)) {
            return;
        }

        // 배송 취소 처리
        delivery.setDeliveryStatus(DeliveryStatus.CANCEL);
    }

    /**
     * 운송장 번호 램덤 생성
     * @return generatedString 운송장번호
     */
    public String generateTrackingnumber() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 90; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit,rightLimit + 1)
            .filter(i -> (i <= 57 || i >= 65))
            .limit(targetStringLength)
            .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
            .toString();

        return generatedString.toUpperCase();
    }

}
