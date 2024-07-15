package org.demo.documentation.fields.multivalue.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity191Repository extends JpaRepository<MyEntity191, Long>, JpaSpecificationExecutor<MyEntity191> {

}