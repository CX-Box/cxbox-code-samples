package org.demo.documentation.fields.multipleselect.longvalues;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.multipleselect.longvalues.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyExample3358Meta extends FieldMetaBuilder<MyExample3358DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3358DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setConcreteValues(MyExample3358DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample3358DTO_.customField);
		fields.setEnabled(MyExample3358DTO_.comment);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3358DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3358DTO_.customField);
		}
		fields.enableFilter(MyExample3358DTO_.customField);
		fields.enableSort(MyExample3358DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}