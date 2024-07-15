package org.demo.documentation.widgets.list.base.forfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3002Pick2Repository extends JpaRepository<MyEntity3002Pick2, Long>, JpaSpecificationExecutor<MyEntity3002Pick2> {

}