package org.demo.documentation.fields.multivalue.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity190Repository extends JpaRepository<MyEntity190, Long>, JpaSpecificationExecutor<MyEntity190> {

}