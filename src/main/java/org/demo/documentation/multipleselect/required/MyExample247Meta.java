package org.demo.documentation.multipleselect.required;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.multipleselect.required.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample247Meta extends FieldMetaBuilder<MyExample247DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample247DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setDictionaryTypeWithCustomValues(MyExample247DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.toArray(String[]::new));
		fields.setEnabled(MyExample247DTO_.customField);
		fields.setRequired(MyExample247DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample247DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample247DTO_.customField);
		}
		fields.enableFilter(MyExample247DTO_.customField);
	}

}