package org.demo.documentation.radio.color;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.radio.color.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample21Meta extends FieldMetaBuilder<MyExample21DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample21DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample21DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample21DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample21DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample21DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample21DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample21DTO_.customField);
	}

}