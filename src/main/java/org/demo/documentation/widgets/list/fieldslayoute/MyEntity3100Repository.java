package org.demo.documentation.widgets.list.fieldslayoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3100Repository extends JpaRepository<MyEntity3100, Long>, JpaSpecificationExecutor<MyEntity3100> {

}