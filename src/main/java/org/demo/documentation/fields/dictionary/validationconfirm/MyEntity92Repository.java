package org.demo.documentation.fields.dictionary.validationconfirm;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity92Repository extends JpaRepository<MyEntity92, Long>, JpaSpecificationExecutor<MyEntity92> {

}