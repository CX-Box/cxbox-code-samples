package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;

import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4002External;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity4002ExternalRepository extends
 JpaRepository<MyEntity4002External, Long>, JpaSpecificationExecutor<MyEntity4002External>,
        QueryLanguageRepository<MyEntity4002External, Long> {


     public List <MyEntity4002External> findAllByCustomField(String customField);
}