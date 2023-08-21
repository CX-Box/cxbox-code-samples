package org.demo.documentation.multivaluero.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity204Repository extends JpaRepository<MyEntity204, Long>, JpaSpecificationExecutor<MyEntity204> {

}