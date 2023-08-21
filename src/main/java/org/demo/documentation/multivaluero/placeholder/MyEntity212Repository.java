package org.demo.documentation.multivaluero.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity212Repository extends JpaRepository<MyEntity212, Long>, JpaSpecificationExecutor<MyEntity212> {

}