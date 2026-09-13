package org.demo.documentation.fields.multivaluetree.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3324MultivalueRepository extends JpaRepository<MyEntity3324Multivalue, Long>, JpaSpecificationExecutor<MyEntity3324Multivalue> {

}