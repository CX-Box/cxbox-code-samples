package org.demo.documentation.inlinepicklist.validationdynamic;

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
public class MyEntity327PickListMeta extends FieldMetaBuilder<MyEntity327PickDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity327PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyEntity327PickDTO_.id);
		fields.setEnabled(MyEntity327PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity327PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

	}

}
