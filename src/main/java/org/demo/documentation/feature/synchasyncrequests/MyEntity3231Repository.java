package org.demo.documentation.feature.synchasyncrequests;

import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3231Repository extends JpaRepository<MyEntity3231, Long>, JpaSpecificationExecutor<MyEntity3231> {

    List<MyEntity3231> findAllByStatusResponse(StatusEnum customField);
}

