package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity3137;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3137Repository extends
		JpaRepository<MyEntity3137, Long>, JpaSpecificationExecutor<MyEntity3137>,
		QueryLanguageRepository<MyEntity3137, Long> {


	List<MyEntity3137> findAllByCustomField(String customField);
}