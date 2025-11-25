package org.demo.documentation.feature.massoperations;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity6101Repository extends JpaRepository<MyEntity6101, Long>, JpaSpecificationExecutor<MyEntity6101> {

}
