package org.demo.documentation.fields.text.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity44Repository extends JpaRepository<MyEntity44, Long>, JpaSpecificationExecutor<MyEntity44> {

}