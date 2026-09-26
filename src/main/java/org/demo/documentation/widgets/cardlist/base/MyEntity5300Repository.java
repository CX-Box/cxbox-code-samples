package org.demo.documentation.widgets.cardlist.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity5300Repository extends JpaRepository<MyEntity5300, Long>, JpaSpecificationExecutor<MyEntity5300> {

}
