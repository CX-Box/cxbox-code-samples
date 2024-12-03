package org.demo.documentation.fields.dictionary.dictionarylov.basic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity352Repository extends JpaRepository<MyEntity352, Long>, JpaSpecificationExecutor<MyEntity352> {

}
