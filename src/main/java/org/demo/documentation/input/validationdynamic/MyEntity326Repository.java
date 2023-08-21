package org.demo.documentation.input.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity326Repository extends JpaRepository<MyEntity326, Long>, JpaSpecificationExecutor<MyEntity326> {

}