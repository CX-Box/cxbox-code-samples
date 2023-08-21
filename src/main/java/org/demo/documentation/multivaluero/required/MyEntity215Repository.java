package org.demo.documentation.multivaluero.required;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity215Repository extends JpaRepository<MyEntity215, Long>, JpaSpecificationExecutor<MyEntity215> {

}