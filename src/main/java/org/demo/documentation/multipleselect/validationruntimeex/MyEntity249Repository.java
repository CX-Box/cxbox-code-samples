package org.demo.documentation.multipleselect.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity249Repository extends JpaRepository<MyEntity249, Long>, JpaSpecificationExecutor<MyEntity249> {

}