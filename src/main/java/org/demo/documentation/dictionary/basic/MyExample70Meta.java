package org.demo.documentation.dictionary.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.dictionary.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample70Meta extends FieldMetaBuilder<MyExample70DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample70DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample70DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample70DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample70DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample70DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample70DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample70DTO_.customField);
	}

}