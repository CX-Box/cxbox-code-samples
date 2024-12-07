package org.demo.documentation.fields.dictionary.dictionarylov.dictionary;

import org.cxbox.model.dictionary.entity.DictionaryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MyEntity357Repository extends JpaRepository<DictionaryItem, Long>, JpaSpecificationExecutor<DictionaryItem> {

}
