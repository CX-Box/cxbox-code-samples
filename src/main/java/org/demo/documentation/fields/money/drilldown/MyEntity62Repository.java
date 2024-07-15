package org.demo.documentation.fields.money.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity62Repository extends JpaRepository<MyEntity62, Long>, JpaSpecificationExecutor<MyEntity62> {

}