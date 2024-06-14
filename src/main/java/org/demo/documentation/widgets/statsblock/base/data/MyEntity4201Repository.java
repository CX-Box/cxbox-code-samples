package org.demo.documentation.widgets.statsblock.base.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4201Repository extends JpaRepository<MyEntity4201, Long>, JpaSpecificationExecutor<MyEntity4201> {

}