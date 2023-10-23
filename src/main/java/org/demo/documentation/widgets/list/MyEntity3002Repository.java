package org.demo.documentation.widgets.list;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3002Repository extends JpaRepository<MyEntity3002, Long>, JpaSpecificationExecutor<MyEntity3002> {

}