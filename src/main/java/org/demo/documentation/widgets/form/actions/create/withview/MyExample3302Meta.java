package org.demo.documentation.widgets.form.actions.create.withview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3302Meta extends FieldMetaBuilder<MyExample3302DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3302DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3302DTO_.customFieldText);
		fields.setEnabled(MyExample3302DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3302DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3302DTO_.customFieldText);
	}

}