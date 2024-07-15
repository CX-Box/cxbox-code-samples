package org.demo.documentation.fields.percent.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity6Repository extends JpaRepository<MyEntity6, Long>, JpaSpecificationExecutor<MyEntity6> {

}