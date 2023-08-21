package org.demo.documentation.picklist.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity124Repository extends JpaRepository<MyEntity124, Long>, JpaSpecificationExecutor<MyEntity124> {

}