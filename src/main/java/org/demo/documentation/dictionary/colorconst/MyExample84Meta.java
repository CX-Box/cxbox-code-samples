package org.demo.documentation.dictionary.colorconst;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.dictionary.colorconst.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample84Meta extends FieldMetaBuilder<MyExample84DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample84DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample84DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample84DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample84DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample84DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample84DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample84DTO_.customField);
	}

}