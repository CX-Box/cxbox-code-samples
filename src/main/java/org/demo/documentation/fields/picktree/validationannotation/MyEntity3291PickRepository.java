package org.demo.documentation.fields.picktree.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3291PickRepository extends JpaRepository<MyEntity3291Pick, Long>, JpaSpecificationExecutor<MyEntity3291> {

}