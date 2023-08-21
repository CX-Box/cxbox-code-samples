package org.demo.documentation.multipleselect.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity260Repository extends JpaRepository<MyEntity260, Long>, JpaSpecificationExecutor<MyEntity260> {

}