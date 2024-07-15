package org.demo.documentation.fields.radio.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity24Repository extends JpaRepository<MyEntity24, Long>, JpaSpecificationExecutor<MyEntity24> {

}