package org.demo.documentation.widgets.cardlist.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5302Meta extends FieldMetaBuilder<MyExample5302DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5302DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5302DTO_.document,
				MyExample5302DTO_.documentId,
				MyExample5302DTO_.customField,
				MyExample5302DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5302DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5302DTO_.customField);
	}

}
