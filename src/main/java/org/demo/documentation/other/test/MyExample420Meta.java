package org.demo.documentation.other.test;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample420Meta extends FieldMetaBuilder<MyExample420DTO> {


	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample420DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample420DTO_.customFieldForceActive2);
		fields.setEnabled(MyExample420DTO_.customFieldForceActive3);
		fields.setEnabled(MyExample420DTO_.customFieldForceActive);

		fields.setEnabled(MyExample420DTO_.customField3);
		fields.setEnabled(MyExample420DTO_.customField2);
		fields.setEnabled(MyExample420DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample420DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample420DTO_.customFieldForceActive2);
		fields.enableFilter(MyExample420DTO_.customFieldForceActive3);
		fields.enableFilter(MyExample420DTO_.customFieldForceActive);

		fields.setForceActive(MyExample420DTO_.customFieldForceActive);
		fields.setForceActive(MyExample420DTO_.customFieldForceActive2);
		fields.setForceActive(MyExample420DTO_.customFieldForceActive3);

		fields.enableFilter(MyExample420DTO_.customField3);
		fields.enableFilter(MyExample420DTO_.customField2);
		fields.enableFilter(MyExample420DTO_.customField);
	}

}