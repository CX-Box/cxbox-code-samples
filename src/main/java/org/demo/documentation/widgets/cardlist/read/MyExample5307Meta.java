package org.demo.documentation.widgets.cardlist.read;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5307Meta extends FieldMetaBuilder<MyExample5307DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5307DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5307DTO_.document,
				MyExample5307DTO_.documentId,
				MyExample5307DTO_.customField,
				MyExample5307DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5307DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5307DTO_.customField);
	}

}
