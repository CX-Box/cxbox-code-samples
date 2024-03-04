package org.demo.documentation.time.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3507Repository extends JpaRepository<MyEntity3507, Long>, JpaSpecificationExecutor<MyEntity3507> {

}