package org.demo.documentation.multivaluehover.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity230Repository extends JpaRepository<MyEntity230, Long>, JpaSpecificationExecutor<MyEntity229> {

}