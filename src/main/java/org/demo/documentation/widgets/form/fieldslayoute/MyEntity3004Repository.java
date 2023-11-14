package org.demo.documentation.widgets.form.fieldslayoute;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3004Repository extends JpaRepository<MyEntity3004, Long>, JpaSpecificationExecutor<MyEntity3004> {

}