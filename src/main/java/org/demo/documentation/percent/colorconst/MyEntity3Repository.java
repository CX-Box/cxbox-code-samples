package org.demo.documentation.percent.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3Repository extends JpaRepository<MyEntity3, Long>, JpaSpecificationExecutor<MyEntity3> {

}