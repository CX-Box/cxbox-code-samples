package org.demo.documentation.widgets.assoctree.colortitle.colorconst;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3332MultiPick0Meta extends FieldMetaBuilder<MyEntity3332MultiPick0DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3332MultiPick0DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3332MultiPick0DTO_.customFieldText);
		fields.setEnabled(MyEntity3332MultiPick0DTO_.id);
		fields.setEnabled(MyEntity3332MultiPick0DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3332MultiPick0DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3332MultiPick0DTO_.parentId);
		fields.enableFilter(MyEntity3332MultiPick0DTO_.customFieldText);

	}

}
