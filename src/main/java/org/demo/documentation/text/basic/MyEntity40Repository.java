package org.demo.documentation.text.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity40Repository extends JpaRepository<MyEntity40, Long>, JpaSpecificationExecutor<MyEntity40> {

}