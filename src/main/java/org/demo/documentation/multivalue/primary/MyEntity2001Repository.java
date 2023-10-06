package org.demo.documentation.multivalue.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity2001Repository extends JpaRepository<MyEntity2001, Long>, JpaSpecificationExecutor<MyEntity2001> {

}