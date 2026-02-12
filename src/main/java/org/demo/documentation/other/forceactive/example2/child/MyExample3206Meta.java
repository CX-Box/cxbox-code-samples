package org.demo.documentation.other.forceactive.example2.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3206Meta extends FieldMetaBuilder<MyExample3206DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3206DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3206DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3206DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}