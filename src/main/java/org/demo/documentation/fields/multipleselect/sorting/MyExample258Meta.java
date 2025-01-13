package org.demo.documentation.fields.multipleselect.sorting;

import java.util.Arrays;
import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample258Meta extends FieldMetaBuilder<MyExample258DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample258DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setConcreteValues(MyExample258DTO_.customField, Arrays.stream(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum.values())
				.map(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample258DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample258DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample258DTO_.customField);
		}
		fields.enableFilter(MyExample258DTO_.customField);
		fields.enableSort(MyExample258DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}