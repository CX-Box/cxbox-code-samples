package org.demo.documentation.multivaluehover.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity224Repository extends JpaRepository<MyEntity224, Long>, JpaSpecificationExecutor<MyEntity224> {

}