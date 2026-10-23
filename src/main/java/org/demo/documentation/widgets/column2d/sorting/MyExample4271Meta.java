package org.demo.documentation.widgets.column2d.sorting;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4271Meta extends AnySourceFieldMetaBuilder<MyExample4271DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4271DTO> fields, BcDescription bc,
			String id, String parentId) {
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4271DTO> fields, BcDescription bc, String parentId) {
		fields.enableSort(MyExample4271DTO_.sum);
	}
	// --8<-- [end:buildIndependentMeta]

}
