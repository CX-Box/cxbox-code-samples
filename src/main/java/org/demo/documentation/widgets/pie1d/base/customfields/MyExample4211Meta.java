package org.demo.documentation.widgets.pie1d.base.customfields;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample4211Meta extends AnySourceFieldMetaBuilder<MyExample4211DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4211DTO> fields, BcDescription bc,
									  String id, String parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4211DTO> fields, BcDescription bc, String parentId) {
	}
}
