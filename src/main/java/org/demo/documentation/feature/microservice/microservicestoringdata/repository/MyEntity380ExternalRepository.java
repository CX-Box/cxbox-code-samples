package org.demo.documentation.feature.microservice.microservicestoringdata.repository;


import org.demo.documentation.feature.microservice.microservicestoringdata.core.querylang.springdata.core.QueryLanguageRepository;
import org.demo.documentation.feature.microservice.microservicestoringdata.repository.entity.MyEntity380External;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface MyEntity380ExternalRepository extends
		JpaRepository<MyEntity380External, Long>, JpaSpecificationExecutor<MyEntity380External>,
		QueryLanguageRepository<MyEntity380External, Long> {

	List<MyEntity380External> findAllByType(String type);

	Optional<MyEntity380External> findAllByTypeAndKey(String type, String key);


}