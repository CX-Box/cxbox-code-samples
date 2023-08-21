package org.demo.documentation.money.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity64Repository extends JpaRepository<MyEntity64, Long>, JpaSpecificationExecutor<MyEntity64> {

}