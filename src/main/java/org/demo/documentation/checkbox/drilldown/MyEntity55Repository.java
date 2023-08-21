package org.demo.documentation.checkbox.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity55Repository extends JpaRepository<MyEntity55, Long>, JpaSpecificationExecutor<MyEntity55> {

}