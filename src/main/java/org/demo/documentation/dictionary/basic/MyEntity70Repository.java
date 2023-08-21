package org.demo.documentation.dictionary.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity70Repository extends JpaRepository<MyEntity70, Long>, JpaSpecificationExecutor<MyEntity70> {

}