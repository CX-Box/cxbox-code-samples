package org.demo.documentation.widgets.tree.base.allType;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.base.allType.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class Myexample3262MetaBuilder extends FieldMetaBuilder<Myexample3262DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3262DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setDisabled(Myexample3262DTO_.customField);
		fields.setDisabled(Myexample3262DTO_.customFieldHidden);
		fields.setDisabled(Myexample3262DTO_.customFieldText);
		fields.setDisabled(Myexample3262DTO_.customFieldDateTime);
		fields.setDisabled(Myexample3262DTO_.customFieldCheckbox);
		fields.setDisabled(Myexample3262DTO_.customFieldDate);
		fields.setDisabled(Myexample3262DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumValues(Myexample3262DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setDisabled(Myexample3262DTO_.customFieldDictionary);
		fields.setDisabled(Myexample3262DTO_.customFieldFileUploadId);
		fields.setDisabled(Myexample3262DTO_.customFieldFileUpload);
		fields.setDisabled(Myexample3262DTO_.customFieldNumber);
		fields.setDisabled(Myexample3262DTO_.customFieldPercent);
		fields.setDisabled(Myexample3262DTO_.customFieldPickListId);
		fields.setDisabled(Myexample3262DTO_.customFieldPickList);
		fields.setDisabled(Myexample3262DTO_.customFieldInlineId);
		fields.setDisabled(Myexample3262DTO_.customFieldInline);
		fields.setDisabled(Myexample3262DTO_.customFieldMoney);
		fields.setEnumValues(Myexample3262DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setDisabled(Myexample3262DTO_.customFieldRadio);
		fields.setConcreteValues(Myexample3262DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setDisabled(Myexample3262DTO_.customFieldMultipleSelect);
		fields.setDisabled(Myexample3262DTO_.customFieldMultivalue);
		fields.setDisabled(Myexample3262DTO_.customFieldMultivalueHover);
		fields.setDisabled(Myexample3262DTO_.customFieldHint);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3262DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3262DTO_.customField);
		fields.enableFilter(Myexample3262DTO_.customFieldText);
		fields.enableFilter(Myexample3262DTO_.customFieldDateTime);
		fields.enableFilter(Myexample3262DTO_.customFieldCheckbox);
		fields.enableFilter(Myexample3262DTO_.customFieldDate);
		fields.enableFilter(Myexample3262DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, Myexample3262DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(Myexample3262DTO_.customFieldDictionary);
		fields.enableFilter(Myexample3262DTO_.customFieldFileUpload);
		fields.enableFilter(Myexample3262DTO_.customFieldNumber);
		fields.enableFilter(Myexample3262DTO_.customFieldPercent);
		fields.enableFilter(Myexample3262DTO_.customFieldPickList);
		fields.enableFilter(Myexample3262DTO_.customFieldInline);
		fields.enableFilter(Myexample3262DTO_.customFieldMoney);
		fields.setEnumFilterValues(fields, Myexample3262DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.enableFilter(Myexample3262DTO_.customFieldRadio);
		fields.setConcreteFilterValues(Myexample3262DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.collect(Collectors.toList()));
		fields.enableFilter(Myexample3262DTO_.customFieldMultipleSelect);
		fields.enableFilter(Myexample3262DTO_.customFieldMultivalue);
		fields.enableFilter(Myexample3262DTO_.customFieldMultivalueHover);
		fields.enableFilter(
				Myexample3262DTO_.id
		);
		fields.enableSort(
				Myexample3262DTO_.id
		);
	}

}
