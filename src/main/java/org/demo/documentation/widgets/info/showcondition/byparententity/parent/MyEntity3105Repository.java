package org.demo.documentation.widgets.info.showcondition.byparententity.parent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3105Repository extends JpaRepository<MyEntity3105, Long>, JpaSpecificationExecutor<MyEntity3105> {

}