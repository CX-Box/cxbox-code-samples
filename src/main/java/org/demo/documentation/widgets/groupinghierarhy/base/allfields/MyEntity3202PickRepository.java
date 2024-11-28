package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3202PickRepository extends JpaRepository<MyEntity3202Pick, Long>, JpaSpecificationExecutor<MyEntity3202Pick> {

}
