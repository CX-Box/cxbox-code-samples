package org.demo.documentation.additional.forceactiveshowcondition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity1432Repository extends JpaRepository<MyEntity1432, Long>, JpaSpecificationExecutor<MyEntity1432> {

}
