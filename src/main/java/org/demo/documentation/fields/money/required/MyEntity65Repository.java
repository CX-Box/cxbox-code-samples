package org.demo.documentation.fields.money.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity65Repository extends JpaRepository<MyEntity65, Long>, JpaSpecificationExecutor<MyEntity65> {

}