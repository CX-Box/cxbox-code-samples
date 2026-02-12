package org.demo.documentation.feature.postaction.drilldownandwaituntil.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3234Meta extends FieldMetaBuilder<MyExample3234DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3234DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3234DTO_.customField);
		fields.setEnabled(MyExample3234DTO_.customFieldForm);
		fields.setPlaceholder(MyExample3234DTO_.customFieldForm, "The search is performed on `customField` with an exact match.");

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3234DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}