package org.demo.documentation.widgets.form.showcondition.byparententity.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3006Repository extends JpaRepository<MyEntity3006, Long>, JpaSpecificationExecutor<MyEntity3006> {

}