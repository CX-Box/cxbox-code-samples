package org.demo.documentation.multivaluero.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity222Repository extends JpaRepository<MyEntity222, Long>, JpaSpecificationExecutor<MyEntity222> {

}