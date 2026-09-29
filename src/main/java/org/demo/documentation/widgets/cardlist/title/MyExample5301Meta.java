package org.demo.documentation.widgets.cardlist.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5301Meta extends FieldMetaBuilder<MyExample5301DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5301DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5301DTO_.document,
				MyExample5301DTO_.documentId,
				MyExample5301DTO_.customField,
				MyExample5301DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5301DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5301DTO_.customField);
	}

}
