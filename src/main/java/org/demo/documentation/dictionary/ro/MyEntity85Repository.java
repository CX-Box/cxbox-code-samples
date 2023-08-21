package org.demo.documentation.dictionary.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity85Repository extends JpaRepository<MyEntity85, Long>, JpaSpecificationExecutor<MyEntity85> {

}