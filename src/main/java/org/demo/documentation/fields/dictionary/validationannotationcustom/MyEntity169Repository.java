package org.demo.documentation.fields.dictionary.validationannotationcustom;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity169Repository extends JpaRepository<MyEntity169, Long>, JpaSpecificationExecutor<MyEntity169> {

}