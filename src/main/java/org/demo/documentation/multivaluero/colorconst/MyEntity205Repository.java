package org.demo.documentation.multivaluero.colorconst;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity205Repository extends JpaRepository<MyEntity205, Long>, JpaSpecificationExecutor<MyEntity205> {

}