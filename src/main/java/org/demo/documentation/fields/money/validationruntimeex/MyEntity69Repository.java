package org.demo.documentation.fields.money.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity69Repository extends JpaRepository<MyEntity69, Long>, JpaSpecificationExecutor<MyEntity69> {

}