package org.demo.documentation.picklist.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity120Repository extends JpaRepository<MyEntity120, Long>, JpaSpecificationExecutor<MyEntity120> {

}