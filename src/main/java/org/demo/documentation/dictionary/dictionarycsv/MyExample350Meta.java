package org.demo.documentation.dictionary.dictionarycsv;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample350Meta extends FieldMetaBuilder<MyExample350DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample350DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}