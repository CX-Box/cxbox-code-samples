package org.demo.documentation.widgets.info.showcondition.bycurrententity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3103Repository extends JpaRepository<MyEntity3103, Long>, JpaSpecificationExecutor<MyEntity3103> {

}