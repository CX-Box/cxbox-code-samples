package org.demo.documentation.widgets.list.base.allfields.forfields;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3002PickRepository extends JpaRepository<MyEntity3002Pick, Long>, JpaSpecificationExecutor<MyEntity3002Pick> {

}