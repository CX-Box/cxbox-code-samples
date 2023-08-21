package org.demo.documentation.checkbox.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity80Repository extends JpaRepository<MyEntity80, Long>, JpaSpecificationExecutor<MyEntity80> {

}