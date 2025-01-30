package org.demo.documentation.feature.synchasyncrequests;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3231Repository extends JpaRepository<MyEntity3231, Long>, JpaSpecificationExecutor<MyEntity3231> {

}
