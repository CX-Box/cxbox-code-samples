package org.demo.documentation.widgets.property.showcondition.hiddenbc.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3183Meta extends FieldMetaBuilder<MyExample3183DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3183DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3183DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3183DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}