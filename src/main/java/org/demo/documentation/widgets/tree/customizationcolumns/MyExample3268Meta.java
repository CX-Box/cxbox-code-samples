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
		fields.setDisabled(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setConcreteValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setDisabled(MyExample3268DTO_.customFieldMultipleSelect);
		fields.setDisabled(MyExample3268DTO_.customFieldMultivalue);
		fields.setDisabled(MyExample3268DTO_.customFieldHidden);
		fields.setDisabled(MyExample3268DTO_.customFieldText);
		fields.setDisabled(MyExample3268DTO_.customFieldDateTime);
		fields.setDisabled(MyExample3268DTO_.customFieldDateTimeWithSeconds);
		fields.setDisabled(MyExample3268DTO_.customFieldFileUploadId);
		fields.setDisabled(MyExample3268DTO_.customFieldFileUpload);
		fields.setDisabled(MyExample3268DTO_.customFieldNumber);
		fields.setDisabled(MyExample3268DTO_.customFieldPercent);
		fields.setDisabled(MyExample3268DTO_.customFieldPickTreeId);
		fields.setDisabled(MyExample3268DTO_.customFieldPickTree);
		fields.setDisabled(MyExample3268DTO_.customFieldInlineId);
		fields.setDisabled(MyExample3268DTO_.customFieldInline);
		fields.setDisabled(MyExample3268DTO_.customFieldMoney);
		fields.setEnumValues(MyExample3268DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setDisabled(MyExample3268DTO_.customFieldRadio);
		fields.setConcreteValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setDisabled(MyExample3268DTO_.customFieldMultipleSelect);
		fields.setDisabled(MyExample3268DTO_.customFieldMultivalue);
		fields.setDisabled(MyExample3268DTO_.customFieldHint);
		fields.setDisabled(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setEnumValues(MyExample3268DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setDisabled(MyExample3268DTO_.customFieldDictionary);
		fields.setDisabled(MyExample3268DTO_.customFieldCheckBox);
		fields.setDisabled(MyExample3268DTO_.customFieldDate);
		fields.setDisabled(MyExample3268DTO_.customFieldInput);
		fields.setDisabled(MyExample3268DTO_.customField);
		fields.setRequired(MyExample3268DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3268DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setConcreteFilterValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.toList());
		fields.enableFilter(MyExample3268DTO_.customFieldMultipleSelect);
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalue);
		fields.enableFilter(MyExample3268DTO_.customFieldText);
		fields.enableFilter(MyExample3268DTO_.customFieldDateTime);
		fields.enableFilter(MyExample3268DTO_.customFieldDateTimeWithSeconds);
		fields.enableFilter(MyExample3268DTO_.customFieldFileUpload);
		fields.enableFilter(MyExample3268DTO_.customFieldNumber);
		fields.enableFilter(MyExample3268DTO_.customFieldPercent);
		fields.enableFilter(MyExample3268DTO_.customFieldPickTree);
		fields.enableFilter(MyExample3268DTO_.customFieldInline);
		fields.enableFilter(MyExample3268DTO_.customFieldMoney);
		fields.setEnumFilterValues(fields, MyExample3268DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.enableFilter(MyExample3268DTO_.customFieldRadio);
		fields.setConcreteFilterValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.toList());
		fields.enableFilter(MyExample3268DTO_.customFieldMultipleSelect);
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalue);
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setEnumFilterValues(fields, MyExample3268DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3268DTO_.customFieldDictionary);
		fields.enableFilter(MyExample3268DTO_.customFieldCheckBox);
		fields.enableFilter(MyExample3268DTO_.customFieldDate);
		fields.enableFilter(MyExample3268DTO_.customFieldInput);
	}

}