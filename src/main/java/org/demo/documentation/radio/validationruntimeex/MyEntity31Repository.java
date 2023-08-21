package org.demo.documentation.radio.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity31Repository extends JpaRepository<MyEntity31, Long>, JpaSpecificationExecutor<MyEntity31> {

}