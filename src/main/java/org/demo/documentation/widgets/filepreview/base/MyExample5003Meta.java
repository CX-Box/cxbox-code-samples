package org.demo.documentation.widgets.filepreview.base;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5003Meta extends FieldMetaBuilder<MyExample5003DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5003DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5003DTO_.customFieldId);
		fields.setEnabled(MyExample5003DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5003DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5003DTO_.customFieldId);
	}

}