package org.demo.documentation.widgets.picklist.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3067PickRepository extends JpaRepository<MyEntity3067Pick, Long>, JpaSpecificationExecutor<MyEntity3067Pick> {

}
