package org.demo.documentation.widgets.picklist.fieldslayoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3070Repository extends JpaRepository<MyEntity3070, Long>, JpaSpecificationExecutor<MyEntity3070> {

}
