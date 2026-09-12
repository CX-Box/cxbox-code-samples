package org.demo.documentation.widgets.assoctree.actions.other.buttonassoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3333Meta extends FieldMetaBuilder<MyExample3333DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3333DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3333DTO_.customFieldText);
		fields.setEnabled(MyExample3333DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3333DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3333DTO_.customFieldText);
		fields.enableFilter(MyExample3333DTO_.customField);
	}

}