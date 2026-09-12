package org.demo.documentation.fields.multivaluetree.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3322MultivalueRepository extends JpaRepository<MyEntity3322Multivalue, Long>, JpaSpecificationExecutor<MyEntity3322Multivalue> {

}