package org.demo.documentation.input.additionalproperties;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MaxInputEntityRepository extends JpaRepository<MaxInputEntity, Long>,
		JpaSpecificationExecutor<MaxInputEntity> {

}