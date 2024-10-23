package org.demo.documentation.widgets.info.base.allfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3001Repository extends JpaRepository<MyEntity3001, Long>, JpaSpecificationExecutor<MyEntity3001> {

}