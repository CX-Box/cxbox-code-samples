package org.demo.documentation.fields.inlinepicklist.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity140Repository extends JpaRepository<MyEntity140, Long>, JpaSpecificationExecutor<MyEntity140> {

}