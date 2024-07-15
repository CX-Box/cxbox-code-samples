package org.demo.documentation.fields.multipleselect.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity345Repository extends JpaRepository<MyEntity345, Long>, JpaSpecificationExecutor<MyEntity345> {

}