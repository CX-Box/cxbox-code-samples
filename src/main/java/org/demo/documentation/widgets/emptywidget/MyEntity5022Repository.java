package org.demo.documentation.widgets.emptywidget;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5022Repository extends JpaRepository<MyEntity5022, Long>, JpaSpecificationExecutor<MyEntity5022> {

}
