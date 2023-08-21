package org.demo.documentation.multivaluehover.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity231Repository extends JpaRepository<MyEntity231, Long>, JpaSpecificationExecutor<MyEntity231> {

}