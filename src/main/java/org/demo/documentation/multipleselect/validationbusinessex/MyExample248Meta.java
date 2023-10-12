package org.demo.documentation.multipleselect.validationbusinessex;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.multipleselect.validationbusinessex.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample248Meta extends FieldMetaBuilder<MyExample248DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample248DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setDictionaryTypeWithCustomValues(MyExample248DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.toArray(String[]::new));
		fields.setEnabled(MyExample248DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample248DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample248DTO_.customField);
		}
		fields.enableFilter(MyExample248DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}