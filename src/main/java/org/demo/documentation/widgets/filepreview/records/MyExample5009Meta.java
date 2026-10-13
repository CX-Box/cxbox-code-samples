package org.demo.documentation.widgets.filepreview.records;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5009Meta extends FieldMetaBuilder<MyExample5009DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5009DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5009DTO_.customField);
		fields.setEnabled(MyExample5009DTO_.document);
		fields.setEnabled(MyExample5009DTO_.documentId);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5009DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
