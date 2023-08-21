package org.demo.documentation.multivaluehover.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity242Repository extends JpaRepository<MyEntity242, Long>, JpaSpecificationExecutor<MyEntity241> {

}