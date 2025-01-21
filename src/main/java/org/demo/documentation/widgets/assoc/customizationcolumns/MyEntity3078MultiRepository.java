package org.demo.documentation.widgets.assoc.customizationcolumns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3078MultiRepository extends JpaRepository<MyEntity3078Assoc, Long>, JpaSpecificationExecutor<MyEntity3078Assoc> {

}
