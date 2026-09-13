package org.demo.documentation.fields.multivaluetree.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3315MultivalueRepository extends JpaRepository<MyEntity3315Multivalue, Long>, JpaSpecificationExecutor<MyEntity3315Multivalue> {

}