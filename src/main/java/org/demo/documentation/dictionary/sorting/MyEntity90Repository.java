package org.demo.documentation.dictionary.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity90Repository extends JpaRepository<MyEntity90, Long>, JpaSpecificationExecutor<MyEntity90> {

}