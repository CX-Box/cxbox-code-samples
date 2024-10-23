package org.demo.documentation.widgets.info.base.onefield;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3009Repository extends JpaRepository<MyEntity3009, Long>, JpaSpecificationExecutor<MyEntity3009> {

}
