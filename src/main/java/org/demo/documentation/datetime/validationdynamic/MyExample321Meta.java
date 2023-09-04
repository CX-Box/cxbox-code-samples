package org.demo.documentation.datetime.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample321Meta extends FieldMetaBuilder<MyExample321DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample321DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample321DTO_.customFieldAdditional);
		fields.setEnabled(MyExample321DTO_.customField);
		fields.setPlaceholder(MyExample321DTO_.customField, "More than the current date");
		fields.setPlaceholder(MyExample321DTO_.customFieldAdditional, "More than the current date");

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample321DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample321DTO_.customFieldAdditional);
		fields.enableFilter(MyExample321DTO_.customField);
	}

}