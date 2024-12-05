package org.demo.documentation.feature.administration.dictionary;

import org.cxbox.model.dictionary.entity.DictionaryTypeDesc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DictoryTypeRepository extends JpaRepository<DictionaryTypeDesc, Long>, JpaSpecificationExecutor<DictionaryTypeDesc> {

}
