package org.demo.documentation.widgets.picktree.actions.save.forpicktreepopup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3355PickRepository extends JpaRepository<MyEntity3355Pick, Long>, JpaSpecificationExecutor<MyEntity3355Pick> {

}
