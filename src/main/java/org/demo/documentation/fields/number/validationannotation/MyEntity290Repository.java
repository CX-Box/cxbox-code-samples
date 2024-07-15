package org.demo.documentation.fields.number.validationannotation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity290Repository extends JpaRepository<MyEntity290, Long>, JpaSpecificationExecutor<MyEntity290> {

}