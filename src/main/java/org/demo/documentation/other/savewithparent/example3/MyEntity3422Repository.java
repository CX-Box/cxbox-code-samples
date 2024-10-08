package org.demo.documentation.other.savewithparent.example3;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3422Repository extends JpaRepository<MyEntity3422, Long>, JpaSpecificationExecutor<MyEntity3422> {

}
