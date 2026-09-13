package org.demo.documentation.fields.picktree.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3283PickRepository extends JpaRepository<MyEntity3283Pick, Long>, JpaSpecificationExecutor<MyEntity3283Pick> {

}