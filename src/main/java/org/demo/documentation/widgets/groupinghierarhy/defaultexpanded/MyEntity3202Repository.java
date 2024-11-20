package org.demo.documentation.widgets.groupinghierarhy.defaultexpanded;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3202Repository extends JpaRepository<MyEntity3202, Long>, JpaSpecificationExecutor<MyEntity3202> {

}
