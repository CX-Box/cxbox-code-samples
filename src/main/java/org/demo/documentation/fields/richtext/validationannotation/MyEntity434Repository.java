package org.demo.documentation.fields.richtext.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity434Repository extends JpaRepository<MyEntity434, Long>, JpaSpecificationExecutor<MyEntity434> {

}