package org.demo.documentation.fields.checkbox.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.checkbox.validationbusinessex.MyExample77DTO_;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample289Meta extends FieldMetaBuilder<MyExample289DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample289DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample289DTO_.customFieldAdditional);
		fields.setEnabled(MyExample289DTO_.customField);
		fields.setPlaceholder(MyExample289DTO_.customField,"Can contain only 'True'");
		fields.setPlaceholder(MyExample289DTO_.customFieldAdditional,"Can contain only 'True'");
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample289DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample289DTO_.customFieldAdditional);
		fields.enableFilter(MyExample289DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}