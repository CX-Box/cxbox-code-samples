package org.demo.documentation.fields.suggestion.basic.listvalues;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4601Meta extends FieldMetaBuilder<MyExample4601DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4601DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample4601DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4601DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}