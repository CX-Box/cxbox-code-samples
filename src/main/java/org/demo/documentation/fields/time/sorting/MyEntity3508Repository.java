package org.demo.documentation.fields.time.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3508Repository extends JpaRepository<MyEntity3508, Long>, JpaSpecificationExecutor<MyEntity3508> {

}