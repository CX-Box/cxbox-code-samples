package org.demo.documentation.radio.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.radio.ro.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample23Meta extends FieldMetaBuilder<MyExample23DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample23DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample23DTO_.customField, CustomFieldEnum.values());

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample23DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample23DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample23DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample23DTO_.customField);
	}

}