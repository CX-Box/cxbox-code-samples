package org.demo.documentation.percent.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample328Meta extends FieldMetaBuilder<MyExample328DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample328DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample328DTO_.customFieldAdditional);
		fields.setEnabled(MyExample328DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample328DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample328DTO_.customFieldAdditional);
		fields.enableFilter(MyExample328DTO_.customField);
	}

}