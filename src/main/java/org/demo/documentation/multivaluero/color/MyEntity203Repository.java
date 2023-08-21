package org.demo.documentation.multivaluero.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity203Repository extends JpaRepository<MyEntity203, Long>, JpaSpecificationExecutor<MyEntity203> {

}