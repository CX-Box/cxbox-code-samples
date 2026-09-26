package org.demo.documentation.widgets.cardlist.showcondition.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5313Meta extends FieldMetaBuilder<MyExample5313DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5313DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5313DTO_.document,
				MyExample5313DTO_.documentId,
				MyExample5313DTO_.customField,
				MyExample5313DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5313DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5313DTO_.customField);
	}

}
