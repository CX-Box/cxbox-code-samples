package org.demo.documentation.widgets.property.showcondition.onewidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3147Meta extends FieldMetaBuilder<MyExample3147DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3147DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3147DTO_.customFieldNumber);
		fields.setEnabled(MyExample3147DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3147DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3147DTO_.customFieldNumber);
	}

}