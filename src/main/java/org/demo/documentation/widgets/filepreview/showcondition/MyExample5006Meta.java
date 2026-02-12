package org.demo.documentation.widgets.filepreview.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5006Meta extends FieldMetaBuilder<MyExample5006DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5006DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5006DTO_.customFieldId);
		fields.setEnabled(MyExample5006DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5006DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5006DTO_.customFieldId);
	}

}