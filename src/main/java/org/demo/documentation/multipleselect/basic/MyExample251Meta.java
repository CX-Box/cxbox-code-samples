package org.demo.documentation.multipleselect.basic;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.multipleselect.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample251Meta extends FieldMetaBuilder<MyExample251DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample251DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setDictionaryTypeWithCustomValues(MyExample251DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.toArray(String[]::new));
		fields.setEnabled(MyExample251DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample251DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample251DTO_.customField);
		}
		fields.enableFilter(MyExample251DTO_.customField);
	}

}