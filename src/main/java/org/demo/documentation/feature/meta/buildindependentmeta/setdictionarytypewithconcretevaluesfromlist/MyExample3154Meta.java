package org.demo.documentation.feature.meta.buildindependentmeta.setdictionarytypewithconcretevaluesfromlist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3154Meta extends FieldMetaBuilder<MyExample3154DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3154DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3154DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3154DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}