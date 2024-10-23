package org.demo.documentation.widgets.form.base.allfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3010Repository extends JpaRepository<MyEntity3010, Long>, JpaSpecificationExecutor<MyEntity3010> {

}
