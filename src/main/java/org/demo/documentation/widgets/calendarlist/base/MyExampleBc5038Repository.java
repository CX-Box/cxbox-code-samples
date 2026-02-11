package org.demo.documentation.widgets.calendarlist.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc5038Repository extends JpaRepository<MyExampleBc5038, Long>, JpaSpecificationExecutor<MyExampleBc5038> {


}
