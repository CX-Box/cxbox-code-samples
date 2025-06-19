package org.demo.documentation.other.drilldown.option2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3429Repository extends JpaRepository<MyEntity3429, Long>, JpaSpecificationExecutor<MyEntity3429> {

}
