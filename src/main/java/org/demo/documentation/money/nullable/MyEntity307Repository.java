package org.demo.documentation.money.nullable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity307Repository extends JpaRepository<MyEntity307, Long>, JpaSpecificationExecutor<MyEntity307> {

}