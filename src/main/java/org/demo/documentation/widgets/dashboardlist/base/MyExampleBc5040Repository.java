package org.demo.documentation.widgets.dashboardlist.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MyExampleBc5040Repository extends JpaRepository<MyExampleBc5040, Long>, JpaSpecificationExecutor<MyExampleBc5040> {


}
