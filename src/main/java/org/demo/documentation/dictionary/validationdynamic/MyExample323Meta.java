package org.demo.documentation.dictionary.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.dictionary.validationbusinessex.MyExample91DTO_;
import org.springframework.stereotype.Service;

@Service
public class MyExample323Meta extends FieldMetaBuilder<MyExample323DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample323DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample323DTO_.customField);
		fields.setEnabled(MyExample323DTO_.customFieldAdditional);
		fields.setPlaceholder(MyExample323DTO_.customField,"Only HIGH");
		fields.setPlaceholder(MyExample323DTO_.customFieldAdditional,"Only HIGH");
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample323DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}