package org.demo.documentation.fields.picktree.drilldown;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3285PickRepository extends JpaRepository<MyEntity3285Pick, Long>, JpaSpecificationExecutor<MyEntity3285Pick> {

}