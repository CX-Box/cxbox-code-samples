package org.demo.documentation.multivalue.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity184Repository extends JpaRepository<MyEntity184, Long>, JpaSpecificationExecutor<MyEntity184> {

}