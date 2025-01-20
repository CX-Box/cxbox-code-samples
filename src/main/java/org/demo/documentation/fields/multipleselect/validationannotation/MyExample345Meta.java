package org.demo.documentation.fields.multipleselect.validationannotation;

import java.util.Arrays;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample345Meta extends FieldMetaBuilder<MyExample345DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample345DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {

		fields.setConcreteValues(MyExample345DTO_.customField, Arrays.stream(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum.values())
				.map(org.demo.documentation.fields.multipleselect.basic.enums.CustomFieldEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());

		fields.setEnabled(MyExample345DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample345DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyExample345DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}