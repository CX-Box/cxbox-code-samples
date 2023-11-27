package org.demo.documentation.widgets.form.showcondition.byparententity.parent;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity3007Repository extends JpaRepository<MyEntity3007, Long>, JpaSpecificationExecutor<MyEntity3007> {

}