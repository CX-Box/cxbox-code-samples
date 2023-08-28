package org.demo.documentation.multipleselect.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample334Meta extends FieldMetaBuilder<MyExample334DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample334DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample334DTO_.customField);
		fields.setEnabled(MyExample334DTO_.customFieldAdditional);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample334DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}