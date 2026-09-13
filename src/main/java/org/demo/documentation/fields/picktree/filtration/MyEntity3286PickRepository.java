package org.demo.documentation.fields.picktree.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3286PickRepository extends JpaRepository<MyEntity3286Pick, Long>, JpaSpecificationExecutor<MyEntity3286Pick> {

}