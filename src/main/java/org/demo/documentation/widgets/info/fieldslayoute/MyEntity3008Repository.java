package org.demo.documentation.widgets.info.fieldslayoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3008Repository extends JpaRepository<MyEntity3008, Long>, JpaSpecificationExecutor<MyEntity3008> {

}