package org.demo.repository.core;

import org.demo.documentation.widgets.tree.base.allType.Myexample3262;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface Myexample3262Repository extends JpaRepository<Myexample3262, Long>, JpaSpecificationExecutor<Myexample3262> {

	boolean existsByParentId(Long parentId);

}
