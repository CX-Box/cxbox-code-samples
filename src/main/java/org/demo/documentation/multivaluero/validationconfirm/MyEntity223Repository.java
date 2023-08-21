package org.demo.documentation.multivaluero.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity223Repository extends JpaRepository<MyEntity223, Long>, JpaSpecificationExecutor<MyEntity223> {

}