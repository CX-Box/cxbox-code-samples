package org.demo.documentation.radio.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity21Repository extends JpaRepository<MyEntity21, Long>, JpaSpecificationExecutor<MyEntity21> {

}