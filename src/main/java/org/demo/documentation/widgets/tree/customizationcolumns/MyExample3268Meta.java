package org.demo.documentation.widgets.tree.customizationcolumns;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldMultipleSelectEnum1;
import org.demo.documentation.widgets.tree.customizationcolumns.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyExample3268Meta extends FieldMetaBuilder<MyExample3268DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3268DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setConcreteValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum1.values())
				.map(CustomFieldMultipleSelectEnum1::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample3268DTO_.customFieldMultipleSelect);
		fields.setEnabled(MyExample3268DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample3268DTO_.customFieldHidden);
		fields.setEnabled(MyExample3268DTO_.customFieldText);
		fields.setEnabled(MyExample3268DTO_.customFieldDateTime);
		fields.setEnabled(MyExample3268DTO_.customFieldDateTimeWithSeconds);
		fields.setEnabled(MyExample3268DTO_.customFieldFileUploadId);
		fields.setEnabled(MyExample3268DTO_.customFieldFileUpload);
		fields.setEnabled(MyExample3268DTO_.customFieldNumber);
		fields.setEnabled(MyExample3268DTO_.customFieldPercent);
		fields.setEnabled(MyExample3268DTO_.customFieldPickTreeId);
		fields.setEnabled(MyExample3268DTO_.customFieldPickTree);
		fields.setEnabled(MyExample3268DTO_.customFieldInlineId);
		fields.setEnabled(MyExample3268DTO_.customFieldInline);
		fields.setEnabled(MyExample3268DTO_.customFieldMoney);
		fields.setEnumValues(MyExample3268DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setEnabled(MyExample3268DTO_.customFieldRadio);
		fields.setConcreteValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample3268DTO_.customFieldMultipleSelect);
		fields.setEnabled(MyExample3268DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample3268DTO_.customFieldHint);
		fields.setEnabled(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setEnumValues(MyExample3268DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3268DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3268DTO_.customFieldCheckBox);
		fields.setEnabled(MyExample3268DTO_.customFieldDate);
		fields.setEnabled(MyExample3268DTO_.customFieldInput);
		fields.setEnabled(MyExample3268DTO_.customField);
		fields.setRequired(MyExample3268DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3268DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3268DTO_.customFieldMultivalueHover);
		fields.setConcreteFilterValues(MyExample3268DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum1.values())
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