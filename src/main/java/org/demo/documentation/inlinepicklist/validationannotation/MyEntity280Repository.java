package org.demo.documentation.inlinepicklist.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity280Repository extends JpaRepository<MyEntity280, Long>, JpaSpecificationExecutor<MyEntity281> {

}