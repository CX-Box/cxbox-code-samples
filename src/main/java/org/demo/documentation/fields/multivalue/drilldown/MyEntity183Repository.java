package org.demo.documentation.fields.multivalue.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity183Repository extends JpaRepository<MyEntity183, Long>, JpaSpecificationExecutor<MyEntity183> {

}