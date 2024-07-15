package org.demo.documentation.fields.multipleselect.ro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity253Repository extends JpaRepository<MyEntity253, Long>, JpaSpecificationExecutor<MyEntity253> {

}