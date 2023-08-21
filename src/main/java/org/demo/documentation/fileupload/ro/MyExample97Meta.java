package org.demo.documentation.fileupload.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample97Meta extends FieldMetaBuilder<MyExample97DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample97DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample97DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample97DTO_.customField);
		}
		fields.enableFilter(MyExample97DTO_.customField);
	}

}