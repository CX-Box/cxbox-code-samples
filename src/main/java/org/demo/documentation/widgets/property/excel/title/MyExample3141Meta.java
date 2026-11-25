package org.demo.documentation.widgets.property.excel.title;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3141Meta extends AnySourceFieldMetaBuilder<MyExample3141DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3141DTO> fields, BcDescription bc,
			String id, String parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3141DTO> fields, BcDescription bc, String parentId) {
	}

}
