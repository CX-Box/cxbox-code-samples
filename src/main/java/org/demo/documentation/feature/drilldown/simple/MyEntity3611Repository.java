package org.demo.documentation.feature.drilldown.simple;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3611Repository extends JpaRepository<MyEntity3611, Long>, JpaSpecificationExecutor<MyEntity3611> {

}
