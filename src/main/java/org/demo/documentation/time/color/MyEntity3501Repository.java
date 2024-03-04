package org.demo.documentation.time.color;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3501Repository extends JpaRepository<MyEntity3501, Long>, JpaSpecificationExecutor<MyEntity3501> {

}