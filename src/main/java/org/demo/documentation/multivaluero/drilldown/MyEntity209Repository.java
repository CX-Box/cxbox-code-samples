package org.demo.documentation.multivaluero.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity209Repository extends JpaRepository<MyEntity209, Long>, JpaSpecificationExecutor<MyEntity209> {

}