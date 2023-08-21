package org.demo.documentation.multivaluero.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity208Repository extends JpaRepository<MyEntity208, Long>, JpaSpecificationExecutor<MyEntity208> {

}