package org.demo.documentation.feature.drilldown.byview;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3055Repository extends JpaRepository<MyEntity3055, Long>, JpaSpecificationExecutor<MyEntity3055> {

}
