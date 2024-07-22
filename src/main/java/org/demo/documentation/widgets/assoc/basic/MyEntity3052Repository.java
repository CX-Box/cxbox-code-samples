package org.demo.documentation.widgets.assoc.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3052Repository extends JpaRepository<MyEntity3052, Long>, JpaSpecificationExecutor<MyEntity3052> {

}
