package org.demo.documentation.dateytimewithseconds.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity167Repository extends JpaRepository<MyEntity167, Long>, JpaSpecificationExecutor<MyEntity167> {

}