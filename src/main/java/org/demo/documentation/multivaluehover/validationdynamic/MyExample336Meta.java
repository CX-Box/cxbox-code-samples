package org.demo.documentation.multivaluehover.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample336Meta extends FieldMetaBuilder<MyExample336DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample336DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample336DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}