package org.demo.documentation.widgets.statsblock.drilldown.parentchild.data;

import org.demo.documentation.widgets.statsblock.drilldown.parentchild.data.enums.ExampleStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity4216Repository extends JpaRepository<MyEntity4216, Long>, JpaSpecificationExecutor<MyEntity4216> {

	List<MyEntity4216> findByStatus(ExampleStatus status);
}
