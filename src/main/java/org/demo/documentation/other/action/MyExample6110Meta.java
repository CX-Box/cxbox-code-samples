package org.demo.documentation.other.action;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample6110Meta extends FieldMetaBuilder<MyExample6110DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6110DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6110DTO> fields, InnerBcDescription bcDescription, Long parentId) {

	}
}
