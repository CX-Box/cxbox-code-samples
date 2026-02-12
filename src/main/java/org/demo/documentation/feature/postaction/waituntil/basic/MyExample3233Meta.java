package org.demo.documentation.feature.postaction.waituntil.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample3233Meta extends FieldMetaBuilder<MyExample3233DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3233DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3233DTO_.customFieldForm);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3233DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}