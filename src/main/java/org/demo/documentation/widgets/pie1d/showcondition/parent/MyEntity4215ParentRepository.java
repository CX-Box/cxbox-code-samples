package org.demo.documentation.widgets.pie1d.showcondition.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4215ParentRepository extends JpaRepository<MyEntity4215Parent, Long>,
		JpaSpecificationExecutor<MyEntity4215Parent> {

}
