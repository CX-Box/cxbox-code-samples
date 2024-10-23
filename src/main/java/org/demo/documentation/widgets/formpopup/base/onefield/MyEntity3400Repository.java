package org.demo.documentation.widgets.formpopup.base.onefield;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3400Repository extends JpaRepository<MyEntity3400, Long>, JpaSpecificationExecutor<MyEntity3400> {

}