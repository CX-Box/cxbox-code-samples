package org.demo.documentation.other.drilldown.option;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3421Repository extends JpaRepository<MyEntity3421, Long>, JpaSpecificationExecutor<MyEntity3421> {

}
