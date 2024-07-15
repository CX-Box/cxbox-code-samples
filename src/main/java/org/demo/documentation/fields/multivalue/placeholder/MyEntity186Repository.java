package org.demo.documentation.fields.multivalue.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity186Repository extends JpaRepository<MyEntity186, Long>, JpaSpecificationExecutor<MyEntity186> {

}