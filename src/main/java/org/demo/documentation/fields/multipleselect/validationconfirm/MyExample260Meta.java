package org.demo.documentation.fields.multipleselect.validationconfirm;

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
public class MyExample260Meta extends FieldMetaBuilder<MyExample260DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample260DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setConcreteValues(MyExample260DTO_.customField, Arrays.stream(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum.values())
				.map(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());

		fields.setEnabled(MyExample260DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample260DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample260DTO_.customField);
		}
		fields.enableFilter(MyExample260DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}