package org.demo.documentation.widgets.additionalinfo.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3600Repository extends JpaRepository<MyEntity3600, Long>, JpaSpecificationExecutor<MyEntity3600> {

}