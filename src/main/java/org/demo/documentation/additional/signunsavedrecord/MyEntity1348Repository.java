package org.demo.documentation.additional.signunsavedrecord;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity1348Repository extends JpaRepository<MyEntity1348, Long>, JpaSpecificationExecutor<MyEntity1348> {

}
