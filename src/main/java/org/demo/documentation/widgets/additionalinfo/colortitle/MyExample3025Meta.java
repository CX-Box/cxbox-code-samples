package org.demo.documentation.widgets.additionalinfo.colortitle;


import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.additionalinfo.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3025Meta extends FieldMetaBuilder<MyExample3025DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3025DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3025DTO_.customFieldColorMultivalue);
		fields.setEnabled(MyExample3025DTO_.customFieldColorMultivalueHover);
		fields.setEnabled(MyExample3025DTO_.customFieldColorInlinePicklistId);
		fields.setEnabled(MyExample3025DTO_.customFieldColorInlinePicklist);
		fields.setEnabled(MyExample3025DTO_.customFieldColorPicklistId);
		fields.setEnabled(MyExample3025DTO_.customFieldColorPicklist);
		fields.setEnumValues(MyExample3025DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.setEnabled(MyExample3025DTO_.customFieldColorRadio);
		fields.setEnabled(MyExample3025DTO_.customFieldColorMoney);
		fields.setEnabled(MyExample3025DTO_.customFieldColorPercent);
		fields.setEnabled(MyExample3025DTO_.customFieldColorNumber);
		fields.setEnabled(MyExample3025DTO_.customFieldColorFileUploadeId);
		fields.setEnabled(MyExample3025DTO_.customFieldColorFileUploade);
		fields.setEnumValues(MyExample3025DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.setEnabled(MyExample3025DTO_.customFieldColorDictionary);
		fields.setEnabled(MyExample3025DTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnabled(MyExample3025DTO_.customFieldColorDate);
		fields.setEnabled(MyExample3025DTO_.customFieldColorCheckbox);
		fields.setEnabled(MyExample3025DTO_.customFieldColorDateTime);
		fields.setEnabled(MyExample3025DTO_.customFieldColorText);
		fields.setEnabled(MyExample3025DTO_.customFieldColorInput);
		fields.setEnabled(MyExample3025DTO_.customField);
		fields.setEnabled(MyExample3025DTO_.customFieldText);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3025DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3025DTO_.customFieldColorMultivalue);
		fields.enableFilter(MyExample3025DTO_.customFieldColorMultivalueHover);
		fields.enableFilter(MyExample3025DTO_.customFieldColorInlinePicklist);
		fields.enableFilter(MyExample3025DTO_.customFieldColorPicklist);
		fields.setEnumFilterValues(fields, MyExample3025DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.enableFilter(MyExample3025DTO_.customFieldColorRadio);
		fields.enableFilter(MyExample3025DTO_.customFieldColorMoney);
		fields.enableFilter(MyExample3025DTO_.customFieldColorPercent);
		fields.enableFilter(MyExample3025DTO_.customFieldColorNumber);
		fields.enableFilter(MyExample3025DTO_.customFieldColorFileUploade);
		fields.setEnumFilterValues(fields, MyExample3025DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.enableFilter(MyExample3025DTO_.customFieldColorDictionary);
		fields.enableFilter(MyExample3025DTO_.customFieldColorDateTimeWithSeconds);
		fields.enableFilter(MyExample3025DTO_.customFieldColorDate);
		fields.enableFilter(MyExample3025DTO_.customFieldColorCheckbox);
		fields.enableFilter(MyExample3025DTO_.customFieldColorDateTime);
		fields.enableFilter(MyExample3025DTO_.customFieldColorText);
		fields.enableFilter(MyExample3025DTO_.customFieldColorInput);
	}

}