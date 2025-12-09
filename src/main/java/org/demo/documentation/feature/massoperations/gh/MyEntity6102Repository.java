package org.demo.documentation.feature.massoperations.gh;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity6102Repository extends JpaRepository<MyEntity6102, Long>, JpaSpecificationExecutor<MyEntity6102> {

}
