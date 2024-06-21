package org.demo.documentation.widgets.additionalinfo.base.forfields;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3600Pick2Repository extends JpaRepository<MyEntity3600Pick2, Long>, JpaSpecificationExecutor<MyEntity3600Pick2> {

}