package org.demo.documentation.fields.suggestion.filtration.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3096Meta extends FieldMetaBuilder<MyExample3096DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3096DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3096DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]


	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3096DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3096DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}