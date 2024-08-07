package org.demo.documentation.feature.customizationcolumns.forfields;

import org.demo.documentation.feature.customizationcolumns.MyEntity3135;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3135PickRepository extends JpaRepository<MyEntity3135Pick, Long>, JpaSpecificationExecutor<MyEntity3135Pick> {

}
