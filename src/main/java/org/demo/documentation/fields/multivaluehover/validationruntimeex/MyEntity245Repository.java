package org.demo.documentation.fields.multivaluehover.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity245Repository extends JpaRepository<MyEntity245, Long>, JpaSpecificationExecutor<MyEntity245> {

}