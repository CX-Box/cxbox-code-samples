package org.demo.documentation.feature.bulkupload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3200Repository extends JpaRepository<MyEntity3200, Long>, JpaSpecificationExecutor<MyEntity3200> {

}
