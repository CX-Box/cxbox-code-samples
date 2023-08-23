package org.demo.documentation.picklist.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity401PickPickMeta extends FieldMetaBuilder<MyEntity401PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity401PickPickDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.picklist.validationdynamic.MyEntity401PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.picklist.validationdynamic.MyEntity401PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity401PickPickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
