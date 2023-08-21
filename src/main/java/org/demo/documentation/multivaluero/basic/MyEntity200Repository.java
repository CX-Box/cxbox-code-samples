package org.demo.documentation.multivaluero.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity200Repository extends JpaRepository<MyEntity200, Long>, JpaSpecificationExecutor<MyEntity200> {

}