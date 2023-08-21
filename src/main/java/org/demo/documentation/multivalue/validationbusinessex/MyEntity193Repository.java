package org.demo.documentation.multivalue.validationbusinessex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity193Repository extends JpaRepository<MyEntity193, Long>, JpaSpecificationExecutor<MyEntity193> {

}