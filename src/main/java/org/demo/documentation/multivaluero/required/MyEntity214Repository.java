package org.demo.documentation.multivaluero.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity214Repository extends JpaRepository<MyEntity214, Long>, JpaSpecificationExecutor<MyEntity214> {

}