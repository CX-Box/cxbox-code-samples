package org.demo.documentation.widgets.tree.customizationcolumns;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldRadioEnum;

import java.util.Arrays;

@Service
public class MyExample3268Meta extends FieldMetaBuilder<MyExample3268DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3268DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3268DTO_.customField);
		fields.setRequired(MyExample3268DTO_.customField);
		fields.setEnabled(MyExample3268DTO_.customFieldInput);
		fields.setEnabled(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setEnabled(MyExample3268DTO_.customFieldHint);
		fields.setEnabled(MyExample3268DTO_.customFieldMultivalue);
		fields.setConcreteValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample3268DTO_.customFieldMultipleSelect);
		fields.setEnumValues(MyExample3268DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setEnabled(MyExample3268DTO_.customFieldRadio);
		fields.setEnabled(MyExample3268DTO_.customFieldMoney);
		fields.setEnabled(MyExample3268DTO_.customFieldInlineId);
		fields.setEnabled(MyExample3268DTO_.customFieldInline);
		fields.setEnabled(MyExample3268DTO_.customFieldPickTreeId);
		fields.setEnabled(MyExample3268DTO_.customFieldPickTree);
		fields.setEnabled(MyExample3268DTO_.customFieldPercent);
		fields.setEnabled(MyExample3268DTO_.customFieldNumber);
		fields.setEnabled(MyExample3268DTO_.customFieldFileUploadId);
		fields.setEnabled(MyExample3268DTO_.customFieldFileUpload);
		fields.setEnumValues(MyExample3268DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3268DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3268DTO_.customFieldDateTimeWithSeconds);
		fields.setEnabled(MyExample3268DTO_.customFieldDate);
		fields.setEnabled(MyExample3268DTO_.customFieldCheckbox);
		fields.setEnabled(MyExample3268DTO_.customFieldDateTime);
		fields.setEnabled(MyExample3268DTO_.customFieldText);
		fields.setEnabled(MyExample3268DTO_.customFieldHidden);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3268DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3268DTO_.parentId);
		fields.enableFilter(MyExample3268DTO_.customFieldInput);
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalueHover);
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalue);
		fields.setConcreteFilterValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.toList());
		fields.enableFilter(MyExample3268DTO_.customFieldMultipleSelect);
		fields.setEnumFilterValues(fields, MyExample3268DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.enableFilter(MyExample3268DTO_.customFieldRadio);
		fields.enableFilter(MyExample3268DTO_.customFieldMoney);
		fields.enableFilter(MyExample3268DTO_.customFieldInline);
		fields.enableFilter(MyExample3268DTO_.customFieldPickTree);
		fields.enableFilter(MyExample3268DTO_.customFieldPercent);
		fields.enableFilter(MyExample3268DTO_.customFieldNumber);
		fields.enableFilter(MyExample3268DTO_.customFieldFileUpload);
		fields.setEnumFilterValues(fields, MyExample3268DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3268DTO_.customFieldDictionary);
		fields.enableFilter(MyExample3268DTO_.customFieldDateTimeWithSeconds);
		fields.enableFilter(MyExample3268DTO_.customFieldDate);
		fields.enableFilter(MyExample3268DTO_.customFieldCheckbox);
		fields.enableFilter(MyExample3268DTO_.customFieldDateTime);
		fields.enableFilter(MyExample3268DTO_.customFieldText);
	}

}
