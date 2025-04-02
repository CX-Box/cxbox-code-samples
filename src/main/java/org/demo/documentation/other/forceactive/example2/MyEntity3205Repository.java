package org.demo.documentation.other.forceactive.example2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3205Repository extends JpaRepository<MyEntity3205, Long>, JpaSpecificationExecutor<MyEntity3205> {

}
