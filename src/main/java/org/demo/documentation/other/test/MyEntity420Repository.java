package org.demo.documentation.other.test;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity420Repository extends JpaRepository<MyEntity420, Long>, JpaSpecificationExecutor<MyEntity420> {

}