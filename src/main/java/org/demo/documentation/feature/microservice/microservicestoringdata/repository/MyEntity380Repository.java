package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity380;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MyEntity380Repository extends
        JpaRepository<MyEntity380, Long>, JpaSpecificationExecutor<MyEntity380>,
        QueryLanguageRepository<MyEntity380, Long> {

    Optional<MyEntity380> findAllByTypeAndKey(String type, String key);

    List<MyEntity380> findAllByType(String type);

}