package org.demo.documentation.widgets.list.edit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3700Repository extends JpaRepository<MyEntity3700, Long>, JpaSpecificationExecutor<MyEntity3700> {

}