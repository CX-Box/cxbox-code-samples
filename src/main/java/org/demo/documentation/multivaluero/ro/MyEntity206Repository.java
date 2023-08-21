package org.demo.documentation.multivaluero.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity206Repository extends JpaRepository<MyEntity206, Long>, JpaSpecificationExecutor<MyEntity206> {

}