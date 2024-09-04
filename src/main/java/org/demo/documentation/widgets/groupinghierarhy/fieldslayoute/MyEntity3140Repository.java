package org.demo.documentation.widgets.groupinghierarhy.fieldslayoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3140Repository extends JpaRepository<MyEntity3140, Long>, JpaSpecificationExecutor<MyEntity3140> {

}
