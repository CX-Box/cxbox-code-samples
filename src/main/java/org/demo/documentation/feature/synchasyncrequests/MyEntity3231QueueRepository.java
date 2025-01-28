package org.demo.documentation.feature.synchasyncrequests;

import org.demo.documentation.feature.synchasyncrequests.enums.StatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyEntity3231QueueRepository extends JpaRepository<MyEntity3231Queue, Long>, JpaSpecificationExecutor<MyEntity3231Queue> {

    List<MyEntity3231Queue> findAllByCustomFieldDictionary(StatusEnum customField);
}
