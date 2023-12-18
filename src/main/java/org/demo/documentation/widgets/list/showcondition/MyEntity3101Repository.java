package org.demo.documentation.widgets.list.showcondition;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3101Repository extends JpaRepository<MyEntity3101, Long>, JpaSpecificationExecutor<MyEntity3101> {

}