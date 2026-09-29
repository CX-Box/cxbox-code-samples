package org.demo.documentation.widgets.cardlist.actions.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5309Meta extends FieldMetaBuilder<MyExample5309DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5309DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5309DTO_.document,
				MyExample5309DTO_.documentId,
				MyExample5309DTO_.customField,
				MyExample5309DTO_.customFieldDescription
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5309DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
