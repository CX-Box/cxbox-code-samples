package org.demo.documentation.fields.multivaluetree.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3320MultivalueRepository extends JpaRepository<MyEntity3320Multivalue, Long>, JpaSpecificationExecutor<MyEntity3320Multivalue> {

}