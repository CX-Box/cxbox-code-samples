package org.demo.documentation.multivaluehover.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity336Repository extends JpaRepository<MyEntity336, Long>, JpaSpecificationExecutor<MyEntity336> {

}