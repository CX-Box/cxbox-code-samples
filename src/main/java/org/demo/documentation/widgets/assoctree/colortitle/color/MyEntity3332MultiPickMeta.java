package org.demo.documentation.widgets.assoctree.colortitle.color;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3332MultiPickMeta extends FieldMetaBuilder<MyEntity3332MultiPickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3332MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3332MultiPickDTO_.customFieldText);
		fields.setEnabled(MyEntity3332MultiPickDTO_.id);
		fields.setEnabled(MyEntity3332MultiPickDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3332MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3332MultiPickDTO_.parentId);
		fields.enableFilter(MyEntity3332MultiPickDTO_.customFieldText);

	}

}
