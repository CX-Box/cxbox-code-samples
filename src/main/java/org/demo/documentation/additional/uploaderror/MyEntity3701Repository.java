package org.demo.documentation.additional.uploaderror;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3701Repository extends JpaRepository<MyEntity3701, Long>, JpaSpecificationExecutor<MyEntity3701> {

}
