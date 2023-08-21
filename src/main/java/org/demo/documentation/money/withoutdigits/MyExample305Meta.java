package org.demo.documentation.money.withoutdigits;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample305Meta extends FieldMetaBuilder<MyExample305DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample305DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample305DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample305DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample305DTO_.customField);
	}

}