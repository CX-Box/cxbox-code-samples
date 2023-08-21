package org.demo.documentation.percent.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity9Repository extends JpaRepository<MyEntity9, Long>, JpaSpecificationExecutor<MyEntity9> {

}