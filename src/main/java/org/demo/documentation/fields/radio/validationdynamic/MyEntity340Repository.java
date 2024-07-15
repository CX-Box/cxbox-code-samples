package org.demo.documentation.fields.radio.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity340Repository extends JpaRepository<MyEntity340, Long>, JpaSpecificationExecutor<MyEntity340> {

}