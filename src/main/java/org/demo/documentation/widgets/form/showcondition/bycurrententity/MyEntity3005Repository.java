package org.demo.documentation.widgets.form.showcondition.bycurrententity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3005Repository extends JpaRepository<MyEntity3005, Long>, JpaSpecificationExecutor<MyEntity3005> {

}