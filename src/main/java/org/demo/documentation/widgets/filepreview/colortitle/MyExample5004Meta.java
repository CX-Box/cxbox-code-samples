package org.demo.documentation.widgets.filepreview.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5004Meta extends FieldMetaBuilder<MyExample5004DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5004DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5004DTO_.customFieldId);
		fields.setEnabled(MyExample5004DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5004DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5004DTO_.customFieldId);
	}

}