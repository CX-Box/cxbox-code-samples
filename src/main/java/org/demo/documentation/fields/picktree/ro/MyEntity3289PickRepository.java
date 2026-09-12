package org.demo.documentation.fields.picktree.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3289PickRepository extends JpaRepository<MyEntity3289Pick, Long>, JpaSpecificationExecutor<MyEntity3289Pick> {

}