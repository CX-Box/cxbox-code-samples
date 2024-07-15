package org.demo.documentation.fields.multipleselect.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity251Repository extends JpaRepository<MyEntity251, Long>, JpaSpecificationExecutor<MyEntity251> {

}