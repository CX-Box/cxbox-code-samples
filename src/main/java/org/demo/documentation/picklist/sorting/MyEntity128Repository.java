package org.demo.documentation.picklist.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity128Repository extends JpaRepository<MyEntity128, Long>, JpaSpecificationExecutor<MyEntity128> {

}