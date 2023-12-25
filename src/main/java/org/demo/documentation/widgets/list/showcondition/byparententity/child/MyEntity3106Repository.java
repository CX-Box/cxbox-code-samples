package org.demo.documentation.widgets.list.showcondition.byparententity.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3106Repository extends JpaRepository<MyEntity3106, Long>, JpaSpecificationExecutor<MyEntity3106> {

}