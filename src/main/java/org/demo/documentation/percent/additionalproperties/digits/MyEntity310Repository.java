package org.demo.documentation.percent.additionalproperties.digits;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity310Repository extends JpaRepository<MyEntity310, Long>, JpaSpecificationExecutor<MyEntity310> {

}