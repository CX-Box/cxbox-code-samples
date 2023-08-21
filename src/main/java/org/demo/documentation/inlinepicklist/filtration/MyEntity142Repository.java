package org.demo.documentation.inlinepicklist.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity142Repository extends JpaRepository<MyEntity142, Long>, JpaSpecificationExecutor<MyEntity142> {

}