package org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity1433Repository extends JpaRepository<MyEntity1433, Long>, JpaSpecificationExecutor<MyEntity1433> {

}
