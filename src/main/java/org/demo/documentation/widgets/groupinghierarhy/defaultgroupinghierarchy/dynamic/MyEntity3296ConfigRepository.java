package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3296ConfigRepository extends JpaRepository<MyEntity3296Config, Long>,
		JpaSpecificationExecutor<MyEntity3296Config> {

}
