package org.demo.documentation.fields.picklist.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity120Repository extends JpaRepository<MyEntityPick120, Long>, JpaSpecificationExecutor<MyEntityPick120> {

}