package org.demo.documentation.fields.checkbox.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity75Repository extends JpaRepository<MyEntity75, Long>, JpaSpecificationExecutor<MyEntity75> {

}