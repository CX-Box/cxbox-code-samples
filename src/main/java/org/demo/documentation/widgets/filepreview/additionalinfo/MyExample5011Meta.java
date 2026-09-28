package org.demo.documentation.widgets.filepreview.additionalinfo;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5011Meta extends FieldMetaBuilder<MyExample5011DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5011DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5011DTO_.customField);
		fields.setEnabled(MyExample5011DTO_.document);
		fields.setEnabled(MyExample5011DTO_.documentId);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5011DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
