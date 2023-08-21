package org.demo.documentation.dictionary.dictionarycsv;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity350Repository extends JpaRepository<MyEntity350, Long>, JpaSpecificationExecutor<MyEntity350> {

}