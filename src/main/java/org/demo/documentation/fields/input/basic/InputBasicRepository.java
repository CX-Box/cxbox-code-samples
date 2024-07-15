package org.demo.documentation.fields.input.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InputBasicRepository extends JpaRepository<InputBasic, Long>, JpaSpecificationExecutor<InputBasic> {

}