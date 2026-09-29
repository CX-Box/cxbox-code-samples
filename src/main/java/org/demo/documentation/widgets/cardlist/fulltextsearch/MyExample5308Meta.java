package org.demo.documentation.widgets.cardlist.fulltextsearch;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5308Meta extends FieldMetaBuilder<MyExample5308DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5308DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5308DTO_.document,
				MyExample5308DTO_.documentId,
				MyExample5308DTO_.customField,
				MyExample5308DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5308DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5308DTO_.customField);
	}

}
