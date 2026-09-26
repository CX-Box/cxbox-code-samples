package org.demo.documentation.widgets.cardlist.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5300Meta extends FieldMetaBuilder<MyExample5300DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5300DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5300DTO_.document,
				MyExample5300DTO_.documentId,
				MyExample5300DTO_.customField,
				MyExample5300DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5300DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5300DTO_.customField);
	}

}
