package org.demo.documentation.percent.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5Repository extends JpaRepository<MyEntity5, Long>, JpaSpecificationExecutor<MyEntity5> {

}