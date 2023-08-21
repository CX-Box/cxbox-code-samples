package org.demo.documentation.text.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity47Repository extends JpaRepository<MyEntity47, Long>, JpaSpecificationExecutor<MyEntity47> {

}