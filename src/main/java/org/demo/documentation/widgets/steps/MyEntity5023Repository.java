package org.demo.documentation.widgets.steps;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5023Repository extends JpaRepository<MyEntity5023, Long>, JpaSpecificationExecutor<MyEntity5023> {

}
