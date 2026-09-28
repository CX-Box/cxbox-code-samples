package org.demo.documentation.widgets.cardcarousellist.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5060Meta extends FieldMetaBuilder<MyExample5060DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5060DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5060DTO_.document,
				MyExample5060DTO_.documentId,
				MyExample5060DTO_.customField,
				MyExample5060DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5060DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5060DTO_.customField);
	}

}
