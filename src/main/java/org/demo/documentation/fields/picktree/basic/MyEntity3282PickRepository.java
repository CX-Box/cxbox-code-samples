package org.demo.documentation.fields.picktree.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3282PickRepository extends JpaRepository<MyEntity3282Pick, Long>, JpaSpecificationExecutor<MyEntity3282Pick> {

}