package org.demo.documentation.widgets.form.customname;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3003Repository extends JpaRepository<MyEntity3003, Long>, JpaSpecificationExecutor<MyEntity3003> {

}