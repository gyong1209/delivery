package com.demo.delivery.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

}
