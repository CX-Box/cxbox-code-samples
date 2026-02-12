package org.demo.documentation.other.forceactive.example3.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3208Meta extends FieldMetaBuilder<MyExample3208DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3208DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3208DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3208DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}