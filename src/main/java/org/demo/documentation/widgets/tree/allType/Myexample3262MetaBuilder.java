package org.demo.documentation.widgets.tree.allType;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.tree.allType.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.tree.allType.enums.CustomFieldMultipleSelectEnum;
import org.demo.documentation.widgets.tree.allType.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class Myexample3262MetaBuilder extends FieldMetaBuilder<Myexample3262DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3262DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3262DTO_.customField);
		fields.setEnabled(Myexample3262DTO_.customFieldHidden);
		fields.setEnabled(Myexample3262DTO_.customFieldText);
		fields.setEnabled(Myexample3262DTO_.customFieldDateTime);
		fields.setEnabled(Myexample3262DTO_.customFieldCheckbox);
		fields.setEnabled(Myexample3262DTO_.customFieldDate);
		fields.setEnabled(Myexample3262DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumValues(Myexample3262DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(Myexample3262DTO_.customFieldDictionary);
		fields.setEnabled(Myexample3262DTO_.customFieldFileUploadId);
		fields.setEnabled(Myexample3262DTO_.customFieldFileUpload);
		fields.setEnabled(Myexample3262DTO_.customFieldNumber);
		fields.setEnabled(Myexample3262DTO_.customFieldPercent);
		fields.setEnabled(Myexample3262DTO_.customFieldPickListId);
		fields.setEnabled(Myexample3262DTO_.customFieldPickList);
		fields.setEnabled(Myexample3262DTO_.customFieldInlineId);
		fields.setEnabled(Myexample3262DTO_.customFieldInline);
		fields.setEnabled(Myexample3262DTO_.customFieldMoney);
		fields.setEnumValues(Myexample3262DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setEnabled(Myexample3262DTO_.customFieldRadio);
		fields.setConcreteValues(Myexample3262DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(Myexample3262DTO_.customFieldMultipleSelect);
		fields.setEnabled(Myexample3262DTO_.customFieldMultivalue);
		fields.setEnabled(Myexample3262DTO_.customFieldMultivalueHover);
		fields.setEnabled(Myexample3262DTO_.customFieldHint);
		fields.setEnabled(
				org.demo.documentation.widgets.tree.allType.Myexample3262DTO_.id
		);
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
				org.demo.documentation.widgets.tree.allType.Myexample3262DTO_.id
		);
		fields.enableSort(
				org.demo.documentation.widgets.tree.allType.Myexample3262DTO_.id
		);
	}

}
