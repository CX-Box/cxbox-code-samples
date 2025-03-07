package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3910;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3910Repository extends
        JpaRepository<MyEntity3910, Long>, JpaSpecificationExecutor<MyEntity3910>,
        QueryLanguageRepository<MyEntity3910, Long> {
}