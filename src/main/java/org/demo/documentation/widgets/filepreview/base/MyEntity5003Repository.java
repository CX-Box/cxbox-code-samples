package org.demo.documentation.widgets.filepreview.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5003Repository extends JpaRepository<MyEntity5003, Long>, JpaSpecificationExecutor<MyEntity5003> {

}
