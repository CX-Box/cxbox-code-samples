package org.demo.documentation.fields.time.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3503Repository extends JpaRepository<MyEntity3503, Long>, JpaSpecificationExecutor<MyEntity3503> {

}