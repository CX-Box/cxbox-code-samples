package org.demo.documentation.fields.multivaluetree.primary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3320Repository extends JpaRepository<MyEntity3320, Long>, JpaSpecificationExecutor<MyEntity3320> {

}