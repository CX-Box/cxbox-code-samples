package org.demo.documentation.widgets.form;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3000Repository extends JpaRepository<MyEntity3000, Long>, JpaSpecificationExecutor<MyEntity3000> {

}