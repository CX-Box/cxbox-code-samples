package org.demo.documentation.fields.percent.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity8Repository extends JpaRepository<MyEntity8, Long>, JpaSpecificationExecutor<MyEntity8> {

}