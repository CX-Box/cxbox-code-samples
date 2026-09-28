package org.demo.documentation.widgets.filepreview.header;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5008Meta extends FieldMetaBuilder<MyExample5008DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5008DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5008DTO_.document);
		fields.setEnabled(MyExample5008DTO_.documentId);
		fields.setEnabled(MyExample5008DTO_.customFieldTitle);
		fields.setEnabled(MyExample5008DTO_.customFieldHint);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5008DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
