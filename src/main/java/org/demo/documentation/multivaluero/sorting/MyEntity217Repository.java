package org.demo.documentation.multivaluero.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity217Repository extends JpaRepository<MyEntity217, Long>, JpaSpecificationExecutor<MyEntity217> {

}