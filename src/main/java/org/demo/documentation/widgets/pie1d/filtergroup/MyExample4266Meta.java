package org.demo.documentation.widgets.pie1d.filtergroup;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4266Meta extends AnySourceFieldMetaBuilder<MyExample4266DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4266DTO> fields, BcDescription bc,
			String id, String parentId) {
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4266DTO> fields, BcDescription bc, String parentId) {
		fields.enableFilter(MyExample4266DTO_.value);
	}
	// --8<-- [end:buildIndependentMeta]

}
