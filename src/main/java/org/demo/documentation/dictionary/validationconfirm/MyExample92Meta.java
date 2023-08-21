package org.demo.documentation.dictionary.validationconfirm;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.dictionary.validationconfirm.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample92Meta extends FieldMetaBuilder<MyExample92DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample92DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample92DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample92DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample92DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample92DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample92DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample92DTO_.customField);
	}

}