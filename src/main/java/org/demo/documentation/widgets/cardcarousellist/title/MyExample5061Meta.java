package org.demo.documentation.widgets.cardcarousellist.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5061Meta extends FieldMetaBuilder<MyExample5061DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5061DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5061DTO_.document,
				MyExample5061DTO_.documentId,
				MyExample5061DTO_.customField,
				MyExample5061DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5061DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5061DTO_.customField);
	}

}
