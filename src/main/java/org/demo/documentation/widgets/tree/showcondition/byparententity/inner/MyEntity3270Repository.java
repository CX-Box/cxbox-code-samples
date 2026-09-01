package org.demo.documentation.widgets.tree.showcondition.byparententity.inner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3270Repository extends JpaRepository<Myexample3270, Long>, JpaSpecificationExecutor<Myexample3270> {

}
