package org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields;

import org.cxbox.api.data.dictionary.SimpleDictionary;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields.enums.CustomFieldMultipleSelectEnum;
import org.demo.repository.metabuilder.buildrowdependentmeta.isfieldchangenow.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class MyExample4902Meta extends FieldMetaBuilder<MyExample4902DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4902DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample4902DTO_.suggestionPickListId);
		fields.setEnabled(MyExample4902DTO_.suggestionPickList);
		fields.setEnabled(MyExample4902DTO_.customFieldMultivalueNew);
		fields.setEnabled(MyExample4902DTO_.customFieldHidden);
		fields.setEnabled(MyExample4902DTO_.customFieldText);
		fields.setEnabled(MyExample4902DTO_.customFieldDateTime);
		fields.setEnabled(MyExample4902DTO_.customFieldCheckbox);
		fields.setEnabled(MyExample4902DTO_.customFieldDate);
		fields.setEnabled(MyExample4902DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumValues(MyExample4902DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample4902DTO_.customFieldDictionary);
		fields.setEnabled(MyExample4902DTO_.customFieldFileUploadId);
		fields.setEnabled(MyExample4902DTO_.customFieldFileUpload);
		fields.setEnabled(MyExample4902DTO_.customFieldNumber);
		fields.setEnabled(MyExample4902DTO_.customFieldPercent);
		fields.setEnabled(MyExample4902DTO_.customFieldPickListId);
		fields.setEnabled(MyExample4902DTO_.customFieldPickList);
		fields.setEnabled(MyExample4902DTO_.customFieldInlineId);
		fields.setEnabled(MyExample4902DTO_.customFieldInline);
		fields.setEnabled(MyExample4902DTO_.customFieldMoney);
		fields.setEnumValues(MyExample4902DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setEnabled(MyExample4902DTO_.customFieldRadio);
		fields.setConcreteValues(MyExample4902DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(CustomFieldMultipleSelectEnum::getValue)
				.map(e -> new SimpleDictionary(e, e))
				.toList());
		fields.setEnabled(MyExample4902DTO_.customFieldMultipleSelect);
		fields.setEnabled(MyExample4902DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample4902DTO_.customFieldHint);
		fields.setEnabled(MyExample4902DTO_.customFieldMultivalueHover);
		fields.setEnabled(MyExample4902DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4902DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample4902DTO_.suggestionPickList);
		fields.enableFilter(MyExample4902DTO_.customFieldMultivalueNew);
		fields.enableFilter(MyExample4902DTO_.customFieldText);
		fields.enableFilter(MyExample4902DTO_.customFieldDateTime);
		fields.enableFilter(MyExample4902DTO_.customFieldCheckbox);
		fields.enableFilter(MyExample4902DTO_.customFieldDate);
		fields.enableFilter(MyExample4902DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, MyExample4902DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample4902DTO_.customFieldDictionary);
		fields.enableFilter(MyExample4902DTO_.customFieldFileUpload);
		fields.enableFilter(MyExample4902DTO_.customFieldNumber);
		fields.enableFilter(MyExample4902DTO_.customFieldPercent);
		fields.enableFilter(MyExample4902DTO_.customFieldPickList);
		fields.enableFilter(MyExample4902DTO_.customFieldInline);
		fields.enableFilter(MyExample4902DTO_.customFieldMoney);
		fields.setEnumFilterValues(fields, MyExample4902DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.enableFilter(MyExample4902DTO_.customFieldRadio);
		fields.setConcreteFilterValues(MyExample4902DTO_.customFieldMultipleSelect, Arrays.stream(CustomFieldMultipleSelectEnum.values())
				.map(en -> new SimpleDictionary(en.name(), en.getValue()))
				.collect(Collectors.toList()));
		fields.enableFilter(MyExample4902DTO_.customFieldMultipleSelect);
		fields.enableFilter(MyExample4902DTO_.customFieldMultivalue);
		fields.enableFilter(MyExample4902DTO_.customFieldMultivalueHover);
		if (bcDescription.getName().equals(CxboxMyExample4902Controller.myexamplefa4902.getName())) {
			fields.setForceActive(MyExample4902DTO_.suggestionPickList);
			fields.setForceActive(MyExample4902DTO_.customField);
			fields.setForceActive(MyExample4902DTO_.customFieldText);
			fields.setForceActive(MyExample4902DTO_.customFieldDateTime);
			fields.setForceActive(MyExample4902DTO_.customFieldCheckbox);
			fields.setForceActive(MyExample4902DTO_.customFieldDate);
			fields.setForceActive(MyExample4902DTO_.customFieldDateTimeWithSeconds);
			fields.setForceActive(MyExample4902DTO_.customFieldDictionary);
			fields.setForceActive(MyExample4902DTO_.customFieldFileUpload);
			fields.setForceActive(MyExample4902DTO_.customFieldNumber);
			fields.setForceActive(MyExample4902DTO_.customFieldPercent);
			fields.setForceActive(MyExample4902DTO_.customFieldPickList);
			fields.setForceActive(MyExample4902DTO_.customFieldInline);
			fields.setForceActive(MyExample4902DTO_.customFieldMoney);
			fields.setForceActive(MyExample4902DTO_.customFieldRadio);
			fields.setForceActive(MyExample4902DTO_.customFieldMultipleSelect);
			fields.setForceActive(MyExample4902DTO_.customFieldMultivalue);
			fields.setForceActive(MyExample4902DTO_.customFieldMultivalueNew);
			fields.setForceActive(MyExample4902DTO_.customFieldMultivalueHover);
		}
	}
}