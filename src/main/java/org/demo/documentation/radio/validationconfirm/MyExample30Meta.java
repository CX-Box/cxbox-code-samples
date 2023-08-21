package org.demo.documentation.radio.validationconfirm;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.radio.validationconfirm.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample30Meta extends FieldMetaBuilder<MyExample30DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample30DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample30DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample30DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample30DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample30DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample30DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample30DTO_.customField);
		//
	}


}