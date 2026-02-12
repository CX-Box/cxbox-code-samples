package org.demo.documentation.fields.multipleselect.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyExample251Meta extends FieldMetaBuilder<MyExample251DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample251DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setConcreteValues(MyExample251DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample251DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample251DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample251DTO_.customField);
		}
		fields.enableFilter(MyExample251DTO_.customField);
		fields.enableSort(MyExample251DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}