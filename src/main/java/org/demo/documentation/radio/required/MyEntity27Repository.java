package org.demo.documentation.radio.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity27Repository extends JpaRepository<MyEntity27, Long>, JpaSpecificationExecutor<MyEntity27> {

}