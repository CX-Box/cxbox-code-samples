package org.demo.documentation.widgets.assoc.actions.buttonassoc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3062Repository extends JpaRepository<MyEntity3062, Long>, JpaSpecificationExecutor<MyEntity3062> {

}