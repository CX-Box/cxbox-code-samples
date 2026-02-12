package org.demo.documentation.fields.suggestion.placeholder;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
public class MyExample3086SuggestionMeta extends AnySourceFieldMetaBuilder<MyExample3086SuggestionDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3086SuggestionDTO> fields, BcDescription bcDescription,
									  String id, String parentId) {
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3086SuggestionDTO> fields, BcDescription bcDescription, String parentId) {
	}

}
