package org.demo.documentation.widgets.picklist.base.allfields.forfields.picklistpopup.picklist;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picklist.base.allfields.forfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3067PickPick0Meta extends FieldMetaBuilder<MyEntity3067PickPick0DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3067PickPick0DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3067PickPick0DTO_.customField);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldInput);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldText);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldDateTime);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldCheckbox);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldDate);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumValues(MyEntity3067PickPick0DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldDictionary);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldFileUploadeId);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldFileUploade);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldNumber);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldPercent);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldMoney);
		fields.setEnumValues(MyEntity3067PickPick0DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldRadio);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldPicklistId);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldPicklist);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldInlinePicklistId);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldInlinePicklist);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldMultivalue);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldMultivalueHover);
		fields.setEnabled(MyEntity3067PickPick0DTO_.id);
		fields.setEnabled(MyEntity3067PickPick0DTO_.customFieldPick);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3067PickPick0DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3067PickPick0DTO_.customField);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldInput);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldText);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldDateTime);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldCheckbox);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldDate);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, MyEntity3067PickPick0DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldDictionary);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldFileUploade);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldNumber);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldPercent);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldMoney);
		fields.setEnumFilterValues(fields, MyEntity3067PickPick0DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldRadio);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldPicklist);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldInlinePicklist);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldMultivalue);
		fields.enableFilter(MyEntity3067PickPick0DTO_.customFieldMultivalueHover);

		fields.enableSort(MyEntity3067PickPick0DTO_.customField);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldInput);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldText);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldDateTime);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldCheckbox);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldDate);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldDateTimeWithSeconds);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldDictionary);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldFileUploade);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldNumber);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldPercent);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldMoney);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldRadio);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldPicklist);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldInlinePicklist);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldMultivalue);
		fields.enableSort(MyEntity3067PickPick0DTO_.customFieldMultivalueHover);

	}

}
