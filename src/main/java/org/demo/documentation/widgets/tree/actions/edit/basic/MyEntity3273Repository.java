package org.demo.documentation.widgets.tree.actions.edit.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3273Repository extends JpaRepository<MyEntity3273, Long>, JpaSpecificationExecutor<MyEntity3273> {
	boolean existsByParentId(String parentId);
}