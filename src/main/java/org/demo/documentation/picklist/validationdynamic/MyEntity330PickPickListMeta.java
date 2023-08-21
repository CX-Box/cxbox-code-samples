package org.demo.documentation.picklist.validationdynamic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@RequiredArgsConstructor
@Service
public class MyEntity330PickPickListMeta extends FieldMetaBuilder<MyEntity330PickDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity330PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyEntity330PickDTO_.id);
		fields.setEnabled(MyEntity330PickDTO_.customField);

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity330PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		//
	}

}
