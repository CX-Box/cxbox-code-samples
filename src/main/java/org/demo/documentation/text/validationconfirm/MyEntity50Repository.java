package org.demo.documentation.text.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity50Repository extends JpaRepository<MyEntity50, Long>, JpaSpecificationExecutor<MyEntity50> {

}