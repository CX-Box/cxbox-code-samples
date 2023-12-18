package org.demo.documentation.widgets.info.title;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3102Repository extends JpaRepository<MyEntity3102, Long>, JpaSpecificationExecutor<MyEntity3102> {

}