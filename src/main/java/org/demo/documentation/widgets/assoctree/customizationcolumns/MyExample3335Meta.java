package org.demo.documentation.widgets.assoctree.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3335Meta extends FieldMetaBuilder<MyExample3335DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3335DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3335DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample3335DTO_.customFieldNumber);
		fields.setEnabled(MyExample3335DTO_.customFieldTest);
		fields.setEnabled(MyExample3335DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3335DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3335DTO_.customFieldMultivalue);
		fields.enableFilter(MyExample3335DTO_.customFieldNumber);
		fields.enableFilter(MyExample3335DTO_.customFieldTest);
	}

}