package org.demo.documentation.fields.radio.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity23Repository extends JpaRepository<MyEntity23, Long>, JpaSpecificationExecutor<MyEntity23> {

}