package org.demo.documentation.picklist.color;

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
public class MyEntity121PickPickListMeta extends FieldMetaBuilder<MyEntity121PickDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity121PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.picklist.color.MyEntity121PickDTO_.id);
		fields.setEnabled(org.demo.documentation.picklist.color.MyEntity121PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity121PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		//
	}

}
