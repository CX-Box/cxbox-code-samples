package org.demo.documentation.widgets.assoctree.actions.other.createwithparent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3337Meta extends FieldMetaBuilder<MyExample3337DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3337DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3337DTO_.customFieldReq);
		fields.setEnabled(MyExample3337DTO_.customFieldTextReq);
		fields.setEnabled(MyExample3337DTO_.customFieldText);
		fields.setEnabled(MyExample3337DTO_.customField);
		fields.setRequired(MyExample3337DTO_.customFieldReq);
		fields.setRequired(MyExample3337DTO_.customFieldTextReq);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3337DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3337DTO_.customFieldReq);
		fields.enableFilter(MyExample3337DTO_.customFieldTextReq);
		fields.enableFilter(MyExample3337DTO_.customFieldText);
		fields.enableFilter(MyExample3337DTO_.customField);
	}

}