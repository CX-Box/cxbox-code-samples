package org.demo.documentation.widgets.additionalinfo.base.forfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3600PickRepository extends JpaRepository<MyEntity3600Pick, Long>, JpaSpecificationExecutor<MyEntity3600Pick> {

}