package org.demo.documentation.fields.multivaluetree.sorting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3323MultivalueRepository extends JpaRepository<MyEntity3323Multivalue, Long>, JpaSpecificationExecutor<MyEntity3323Multivalue> {

}