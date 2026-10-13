package org.demo.documentation.widgets.cardcarousellist.fulltextsearch;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5068Meta extends FieldMetaBuilder<MyExample5068DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5068DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5068DTO_.document,
				MyExample5068DTO_.documentId,
				MyExample5068DTO_.customField,
				MyExample5068DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5068DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5068DTO_.customField);
	}

}
