package org.demo.documentation.inlinepicklist.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity132Repository extends JpaRepository<MyEntity132Pick, Long>, JpaSpecificationExecutor<MyEntity132Pick> {

}