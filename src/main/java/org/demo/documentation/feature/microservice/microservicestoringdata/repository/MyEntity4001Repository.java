package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity4001;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity4001Repository extends
 JpaRepository<MyEntity4001, Long>, JpaSpecificationExecutor<MyEntity4001>,
        QueryLanguageRepository<MyEntity4001, Long> {


     public List <MyEntity4001> findAllByCustomField(String customField);
}