package org.demo.documentation.widgets.form.actions.cancelcreate.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3182Meta extends FieldMetaBuilder<MyExample3182DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3182DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3182DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3182DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}