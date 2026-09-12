package org.demo.documentation.fields.picktree.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3290PickRepository extends JpaRepository<MyEntity3290Pick, Long>, JpaSpecificationExecutor<MyEntity3290Pick> {

}