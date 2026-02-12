package org.demo.documentation.widgets.property.sethidden;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.sethidden.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyExample5019Meta extends FieldMetaBuilder<MyExample5019DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5019DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		if (Objects.equals(fields.getCurrentValue(MyExample5019DTO_.customFieldDictionary).orElse(null),
				CustomFieldDictionaryEnum.LOW)) {
			fields.setHidden(MyExample5019DTO_.customField);
		}

		fields.setEnabled(MyExample5019DTO_.customFieldPickListId);
		fields.setEnabled(MyExample5019DTO_.customFieldPickList);
		fields.setEnabled(MyExample5019DTO_.customFieldMV);
		fields.setEnumValues(MyExample5019DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample5019DTO_.customFieldDictionary);
		fields.setEnabled(MyExample5019DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5019DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5019DTO_.customFieldPickList);
		fields.enableFilter(MyExample5019DTO_.customFieldMV);
		fields.setEnumFilterValues(fields, MyExample5019DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample5019DTO_.customFieldDictionary);
		fields.setForceActive(MyExample5019DTO_.customFieldDictionary);
	}

}