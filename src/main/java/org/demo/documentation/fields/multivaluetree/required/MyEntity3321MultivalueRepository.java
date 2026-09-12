package org.demo.documentation.fields.multivaluetree.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3321MultivalueRepository extends JpaRepository<MyEntity3321Multivalue, Long>, JpaSpecificationExecutor<MyEntity3321Multivalue> {

}