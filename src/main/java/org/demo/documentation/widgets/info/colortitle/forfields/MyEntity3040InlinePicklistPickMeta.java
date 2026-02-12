package org.demo.documentation.widgets.info.colortitle.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3040InlinePicklistPickMeta extends FieldMetaBuilder<MyEntity3040InlinePicklistPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3040InlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3040InlinePicklistPickDTO_.id);
		fields.setEnabled(MyEntity3040InlinePicklistPickDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3040InlinePicklistPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
