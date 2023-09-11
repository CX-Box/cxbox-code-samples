package org.demo.documentation.other.alltypes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity422Repository extends JpaRepository<MyEntity422, Long>, JpaSpecificationExecutor<MyEntity422> {

}