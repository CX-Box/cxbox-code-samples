package org.demo.documentation.fields.multipleselect.validationruntimeex;

import lombok.RequiredArgsConstructor;
import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class MyExample249Meta extends FieldMetaBuilder<MyExample249DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample249DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setConcreteValues(MyExample249DTO_.customField, Arrays.stream(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum.values())
				.map(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample249DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample249DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample249DTO_.customField);
		}
		fields.enableFilter(MyExample249DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}