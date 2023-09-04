package org.demo.documentation.fileupload.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample324Meta extends FieldMetaBuilder<MyExample324DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample324DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample324DTO_.customFieldAdditionalId);
		fields.setEnabled(MyExample324DTO_.customFieldAdditional);
		fields.setEnabled(MyExample324DTO_.customFieldId);
		fields.setEnabled(MyExample324DTO_.customField);
		fields.setPlaceholder(MyExample324DTO_.customFieldAdditional, "Only letters");
		fields.setPlaceholder(MyExample324DTO_.customField, "Only letters");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample324DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample324DTO_.customFieldAdditional);
		fields.enableFilter(MyExample324DTO_.customField);
	}

}