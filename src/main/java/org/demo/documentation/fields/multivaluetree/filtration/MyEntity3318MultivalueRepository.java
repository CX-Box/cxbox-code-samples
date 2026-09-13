package org.demo.documentation.fields.multivaluetree.filtration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3318MultivalueRepository extends JpaRepository<MyEntity3318Multivalue, Long>, JpaSpecificationExecutor<MyEntity3318Multivalue> {

}