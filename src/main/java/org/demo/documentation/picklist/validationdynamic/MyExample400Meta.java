package org.demo.documentation.picklist.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample400Meta extends FieldMetaBuilder<MyExample400DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample400DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample400DTO_.customFieldId);
		fields.setEnabled(MyExample400DTO_.customField);
		fields.setEnabled(MyExample400DTO_.customFieldAdditional);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample400DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample400DTO_.customField);
	}

}