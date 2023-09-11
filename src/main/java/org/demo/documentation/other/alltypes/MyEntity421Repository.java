package org.demo.documentation.other.alltypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity421Repository extends JpaRepository<MyEntity421, Long>, JpaSpecificationExecutor<MyEntity421> {

}