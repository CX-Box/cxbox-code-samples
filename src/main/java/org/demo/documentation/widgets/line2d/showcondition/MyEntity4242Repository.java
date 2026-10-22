package org.demo.documentation.widgets.line2d.showcondition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity4242Repository extends JpaRepository<MyEntity4242, Long>, JpaSpecificationExecutor<MyEntity4242> {

}
