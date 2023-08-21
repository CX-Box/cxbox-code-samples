package org.demo.documentation.hint.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity159Repository extends JpaRepository<MyEntity159, Long>, JpaSpecificationExecutor<MyEntity159> {

}