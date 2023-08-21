package org.demo.documentation.multivalue.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity195Repository extends JpaRepository<MyEntity195, Long>, JpaSpecificationExecutor<MyEntity195> {

}