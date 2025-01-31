package org.demo.documentation.feature.synchasyncrequests.example2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3232Repository extends JpaRepository<MyEntity3232, Long>, JpaSpecificationExecutor<MyEntity3232> {

}
