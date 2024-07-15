package org.demo.documentation.fields.text.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity51Repository extends JpaRepository<MyEntity51, Long>, JpaSpecificationExecutor<MyEntity51> {

}