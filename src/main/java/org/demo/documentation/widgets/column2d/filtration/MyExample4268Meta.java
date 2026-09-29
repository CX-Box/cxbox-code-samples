package org.demo.documentation.widgets.column2d.filtration;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4268Meta extends AnySourceFieldMetaBuilder<MyExample4268DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4268DTO> fields, BcDescription bc,
			String id, String parentId) {
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4268DTO> fields, BcDescription bc, String parentId) {
		fields.enableFilter(MyExample4268DTO_.clientName);
	}
	// --8<-- [end:buildIndependentMeta]

}
