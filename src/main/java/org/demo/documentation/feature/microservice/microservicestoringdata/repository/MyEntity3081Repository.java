package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3081;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyEntity3081Repository extends
		JpaRepository<MyEntity3081, Long>, JpaSpecificationExecutor<MyEntity3081>,
		QueryLanguageRepository<MyEntity3081, Long> {

}