package org.demo.documentation.fields.dictionary.validationdynamic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity323Repository extends JpaRepository<MyEntity323, Long>, JpaSpecificationExecutor<MyEntity323> {

}