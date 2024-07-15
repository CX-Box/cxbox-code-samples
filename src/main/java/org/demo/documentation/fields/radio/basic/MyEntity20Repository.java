package org.demo.documentation.fields.radio.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity20Repository extends JpaRepository<MyEntity20, Long>, JpaSpecificationExecutor<MyEntity20> {

}