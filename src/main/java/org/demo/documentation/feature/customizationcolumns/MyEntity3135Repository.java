package org.demo.documentation.feature.customizationcolumns;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3135Repository extends JpaRepository<MyEntity3135, Long>, JpaSpecificationExecutor<MyEntity3135> {

}
