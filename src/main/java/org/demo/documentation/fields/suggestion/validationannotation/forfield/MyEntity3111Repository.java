package org.demo.documentation.fields.suggestion.validationannotation.forfield;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3111Repository extends JpaRepository<MyEntity3111, Long>, JpaSpecificationExecutor<MyEntity3111> {

}
