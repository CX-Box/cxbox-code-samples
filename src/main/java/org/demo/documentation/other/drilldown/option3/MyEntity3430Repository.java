package org.demo.documentation.other.drilldown.option3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3430Repository extends JpaRepository<MyEntity3430, Long>, JpaSpecificationExecutor<MyEntity3430> {

}
