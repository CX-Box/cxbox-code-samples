package org.demo.documentation.money.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
public class MyExample333Meta extends FieldMetaBuilder<MyExample333DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample333DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample333DTO_.customField);
		fields.setEnabled(MyExample333DTO_.customFieldAdditional);
		fields.setPlaceholder(MyExample333DTO_.customField,"More than 100 000.00");
		fields.setPlaceholder(MyExample333DTO_.customFieldAdditional,"More than 100 000.00");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample333DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}