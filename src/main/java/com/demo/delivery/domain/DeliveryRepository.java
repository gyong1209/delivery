package com.demo.delivery.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:3000")
@RepositoryRestResource(excerptProjection = WithWriterProjection.class)
public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

  List<Delivery> findByMemberId(@Param("memberId") Long memberId);

}
