package org.demo.documentation.widgets.column2d.filtergroup;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4270Meta extends AnySourceFieldMetaBuilder<MyExample4270DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4270DTO> fields, BcDescription bc,
			String id, String parentId) {
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4270DTO> fields, BcDescription bc, String parentId) {
		fields.enableFilter(MyExample4270DTO_.sum);
	}
	// --8<-- [end:buildIndependentMeta]

}
