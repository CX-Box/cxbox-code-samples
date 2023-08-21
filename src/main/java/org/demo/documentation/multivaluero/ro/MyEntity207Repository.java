package org.demo.documentation.multivaluero.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity207Repository extends JpaRepository<MyEntity207, Long>, JpaSpecificationExecutor<MyEntity207> {

}