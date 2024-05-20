package org.demo.documentation.getsatrted.microservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4001Repository extends JpaRepository<MyEntity4001, Long>, JpaSpecificationExecutor<MyEntity4001> {

}