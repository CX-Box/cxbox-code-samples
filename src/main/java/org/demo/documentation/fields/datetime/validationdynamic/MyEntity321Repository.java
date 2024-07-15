package org.demo.documentation.fields.datetime.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity321Repository extends JpaRepository<MyEntity321, Long>, JpaSpecificationExecutor<MyEntity321> {

}