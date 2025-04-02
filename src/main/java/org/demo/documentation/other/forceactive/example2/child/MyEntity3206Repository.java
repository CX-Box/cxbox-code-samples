package org.demo.documentation.other.forceactive.example2.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3206Repository extends JpaRepository<MyEntity3206, Long>, JpaSpecificationExecutor<MyEntity3206> {

}
