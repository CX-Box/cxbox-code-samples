package org.demo.documentation.widgets.info.base.onefield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3009Meta extends FieldMetaBuilder<MyExample3009DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3009DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3009DTO_.customFieldText);
		fields.setEnabled(MyExample3009DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3009DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3009DTO_.customFieldText);
	}

}