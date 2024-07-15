package org.demo.documentation.widgets.widget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3021Repository extends JpaRepository<MyEntity3021, Long>, JpaSpecificationExecutor<MyEntity3021> {

}
