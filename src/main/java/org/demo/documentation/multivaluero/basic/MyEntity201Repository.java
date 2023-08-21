package org.demo.documentation.multivaluero.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity201Repository extends JpaRepository<MyEntity201, Long>, JpaSpecificationExecutor<MyEntity201> {

}