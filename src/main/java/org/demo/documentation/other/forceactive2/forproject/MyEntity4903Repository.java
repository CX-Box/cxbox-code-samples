package org.demo.documentation.other.forceactive2.forproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4903Repository extends JpaRepository<MyEntity4903, Long>, JpaSpecificationExecutor<MyEntity4903> {

}
