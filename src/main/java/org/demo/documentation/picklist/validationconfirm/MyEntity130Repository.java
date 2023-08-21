package org.demo.documentation.picklist.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity130Repository extends JpaRepository<MyEntity130, Long>, JpaSpecificationExecutor<MyEntity130> {

}