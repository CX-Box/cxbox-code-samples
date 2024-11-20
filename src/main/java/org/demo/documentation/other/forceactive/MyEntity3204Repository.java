package org.demo.documentation.other.forceactive;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3204Repository extends JpaRepository<MyEntity3204, Long>, JpaSpecificationExecutor<MyEntity3204> {

}
