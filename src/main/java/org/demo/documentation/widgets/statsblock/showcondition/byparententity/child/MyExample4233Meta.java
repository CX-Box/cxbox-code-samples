package org.demo.documentation.widgets.statsblock.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4233Meta extends FieldMetaBuilder<MyExample4233DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4233DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4233DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
