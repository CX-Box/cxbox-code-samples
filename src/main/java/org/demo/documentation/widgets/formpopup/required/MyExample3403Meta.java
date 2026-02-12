package org.demo.documentation.widgets.formpopup.required;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3403Meta extends FieldMetaBuilder<MyExample3403DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3403DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3403DTO_.customFieldRequired2);
		fields.setEnabled(MyExample3403DTO_.customFieldRequired);
		fields.setEnabled(MyExample3403DTO_.customField);
		fields.setRequired(MyExample3403DTO_.customFieldRequired);
		fields.setRequired(MyExample3403DTO_.customFieldRequired2);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3403DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3403DTO_.customFieldRequired2);
		fields.enableFilter(MyExample3403DTO_.customFieldRequired);
	}

}