package org.demo.documentation.multipleselect.validationruntimeex;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.multipleselect.validationruntimeex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample249Meta extends FieldMetaBuilder<MyExample249DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample249DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setDictionaryTypeWithCustomValues(MyExample249DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.toArray(String[]::new));
		fields.setEnabled(MyExample249DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample249DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample249DTO_.customField);
		}
		fields.enableFilter(MyExample249DTO_.customField);
	}

}