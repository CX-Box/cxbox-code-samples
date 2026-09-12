package org.demo.documentation.widgets.assoctree.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3332Meta extends FieldMetaBuilder<MyExample3332DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3332DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3332DTO_.customFieldMultiConst);
		fields.setEnabled(MyExample3332DTO_.customFieldMulti);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3332DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3332DTO_.customFieldMultiConst);
		fields.enableFilter(MyExample3332DTO_.customFieldMulti);
	}

}