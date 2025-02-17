package org.demo.documentation.fields.multipleselect.color;

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
public class MyExample250Meta extends FieldMetaBuilder<MyExample250DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample250DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setConcreteValues(MyExample250DTO_.customField, Arrays.stream(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum.values())
				.map(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample250DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample250DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample250DTO_.customField);
		}
		fields.enableFilter(MyExample250DTO_.customField);
		fields.enableSort(MyExample250DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}