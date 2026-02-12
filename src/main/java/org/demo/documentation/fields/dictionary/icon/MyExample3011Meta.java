package org.demo.documentation.fields.dictionary.icon;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3011Meta extends FieldMetaBuilder<MyExample3011DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3011DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3011DTO_.customFieldMultivalueModeIcon);
		fields.setEnabled(MyExample3011DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample3011DTO_.customFieldDictionaryInlinePickListId);
		fields.setEnabled(MyExample3011DTO_.customFieldDictionaryInlinePickList);
		fields.setEnabled(MyExample3011DTO_.customFieldPickListId);
		fields.setEnabled(MyExample3011DTO_.customFieldPickList);
		fields.setEnabled(MyExample3011DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3011DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3011DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3011DTO_.customFieldMultivalueModeIcon);
		fields.enableFilter(MyExample3011DTO_.customFieldMultivalue);
		fields.enableFilter(MyExample3011DTO_.customFieldDictionaryInlinePickList);
		fields.enableFilter(MyExample3011DTO_.customFieldPickList);
		fields.enableFilter(MyExample3011DTO_.customFieldDictionary);
		fields.enableSort(MyExample3011DTO_.customFieldDictionary);

		fields.setEnumFilterValues(fields, MyExample3011DTO_.customFieldPickList, CustomFieldDictionaryEnum.values());
		fields.setEnumFilterValues(fields, MyExample3011DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());

		fields.setEnumIcons(MyExample3011DTO_.customFieldDictionary, CustomFieldDictionaryEnum.iconMap());
		fields.setEnumValues(MyExample3011DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
	}
	// --8<-- [end:buildIndependentMeta]
}
