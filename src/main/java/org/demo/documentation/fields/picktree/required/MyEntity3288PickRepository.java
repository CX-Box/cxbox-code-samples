package org.demo.documentation.fields.picktree.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3288PickRepository extends JpaRepository<MyEntity3288Pick, Long>, JpaSpecificationExecutor<MyEntity3288Pick> {

}