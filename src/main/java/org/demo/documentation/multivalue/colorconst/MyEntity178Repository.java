package org.demo.documentation.multivalue.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity178Repository extends JpaRepository<MyEntity178, Long>, JpaSpecificationExecutor<MyEntity178> {

}