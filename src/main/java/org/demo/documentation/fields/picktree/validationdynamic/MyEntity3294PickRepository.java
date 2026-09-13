package org.demo.documentation.fields.picktree.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3294PickRepository extends JpaRepository<MyEntity3294Pick, Long>,
		JpaSpecificationExecutor<MyEntity3294Pick> {

}