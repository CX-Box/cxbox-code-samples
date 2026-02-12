package org.demo.documentation.widgets.form.actions.cancelcreate.postaction;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3187Meta extends FieldMetaBuilder<MyExample3187DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3187DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3187DTO_.customFieldText);
		fields.setEnabled(MyExample3187DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3187DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3187DTO_.customFieldText);
	}

}