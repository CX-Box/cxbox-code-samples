package org.demo.documentation.fields.multivaluetree.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3314MultivalueRepository extends JpaRepository<MyEntity3314Multivalue, Long>, JpaSpecificationExecutor<MyEntity3314Multivalue> {

}