package org.demo.documentation.widgets.headerwidget.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5021Repository extends JpaRepository<MyEntity5021, Long>, JpaSpecificationExecutor<MyEntity5021> {

}
