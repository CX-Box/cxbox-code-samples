package org.demo.documentation.radio.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity294Repository extends JpaRepository<MyEntity294, Long>, JpaSpecificationExecutor<MyEntity294> {

}