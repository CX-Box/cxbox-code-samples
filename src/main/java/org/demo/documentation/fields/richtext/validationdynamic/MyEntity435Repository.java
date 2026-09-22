package org.demo.documentation.fields.richtext.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity435Repository extends JpaRepository<MyEntity435, Long>, JpaSpecificationExecutor<MyEntity435> {

}