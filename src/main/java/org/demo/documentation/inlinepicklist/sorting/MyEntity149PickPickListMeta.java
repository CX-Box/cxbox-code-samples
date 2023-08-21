package org.demo.documentation.inlinepicklist.sorting;

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
public class MyEntity149PickPickListMeta extends FieldMetaBuilder<MyEntity149PickDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity149PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.inlinepicklist.sorting.MyEntity149PickDTO_.id);
		fields.setEnabled(org.demo.documentation.inlinepicklist.sorting.MyEntity149PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity149PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

//
	}

}
