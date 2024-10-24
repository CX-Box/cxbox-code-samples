package org.demo.documentation.feature.showcondition.twobcshowcondition.child;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3145Repository extends JpaRepository<MyEntity3145, Long>, JpaSpecificationExecutor<MyEntity3145> {

}
