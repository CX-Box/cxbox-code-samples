package org.demo.documentation.widgets.picktree.title.withouttitle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3345PickRepository extends JpaRepository<MyEntity3345Pick, Long>, JpaSpecificationExecutor<MyEntity3345Pick> {

}
