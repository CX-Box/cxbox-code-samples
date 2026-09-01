package org.demo.documentation.widgets.tree.actions.create.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3265Repository extends JpaRepository<MyEntity3265, Long>, JpaSpecificationExecutor<MyEntity3265> {
	boolean existsByParentId(String parentId);
}
