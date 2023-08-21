package org.demo.documentation.multivalue.placeholder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity187Repository extends JpaRepository<MyEntity187, Long>, JpaSpecificationExecutor<MyEntity187> {

}