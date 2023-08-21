package org.demo.documentation.dictionary.validationruntimeex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity93Repository extends JpaRepository<MyEntity93, Long>, JpaSpecificationExecutor<MyEntity93> {

}