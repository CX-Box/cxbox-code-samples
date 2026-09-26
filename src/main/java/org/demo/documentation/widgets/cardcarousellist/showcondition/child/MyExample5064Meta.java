package org.demo.documentation.widgets.cardcarousellist.showcondition.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5064Meta extends FieldMetaBuilder<MyExample5064DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5064DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5064DTO_.document,
				MyExample5064DTO_.documentId,
				MyExample5064DTO_.customField,
				MyExample5064DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5064DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5064DTO_.customField);
	}

}
