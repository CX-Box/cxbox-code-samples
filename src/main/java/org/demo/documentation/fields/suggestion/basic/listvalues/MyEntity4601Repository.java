package org.demo.documentation.fields.suggestion.basic.listvalues;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4601Repository extends JpaRepository<MyEntity4601, Long>, JpaSpecificationExecutor<MyEntity4601> {

}
