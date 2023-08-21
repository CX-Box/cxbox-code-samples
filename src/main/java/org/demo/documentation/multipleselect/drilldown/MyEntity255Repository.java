package org.demo.documentation.multipleselect.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity255Repository extends JpaRepository<MyEntity255, Long>, JpaSpecificationExecutor<MyEntity255> {

}