package org.demo.documentation.hint.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity161Repository extends JpaRepository<MyEntity161, Long>, JpaSpecificationExecutor<MyEntity161> {

}