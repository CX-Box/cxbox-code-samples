package org.demo.documentation.multivaluero.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity221Repository extends JpaRepository<MyEntity221, Long>, JpaSpecificationExecutor<MyEntity221> {

}