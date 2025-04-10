package org.demo.documentation.other.forceactive.example3.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3208Repository extends JpaRepository<MyEntity3208, Long>, JpaSpecificationExecutor<MyEntity3208> {

}
