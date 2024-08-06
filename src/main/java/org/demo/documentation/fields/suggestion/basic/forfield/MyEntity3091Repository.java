package org.demo.documentation.fields.suggestion.basic.forfield;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3091Repository extends JpaRepository<MyEntity3091, Long>, JpaSpecificationExecutor<MyEntity3091> {

}
