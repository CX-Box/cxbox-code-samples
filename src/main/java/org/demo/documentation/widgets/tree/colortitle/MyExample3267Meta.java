package org.demo.documentation.widgets.tree.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.tree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.tree.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3267Meta extends FieldMetaBuilder<MyExample3267DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3267DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3267DTO_.customFieldText);
		fields.setEnabled(MyExample3267DTO_.customFieldColorInput);
		fields.setEnabled(MyExample3267DTO_.customFieldColorText);
		fields.setEnabled(MyExample3267DTO_.customFieldColorDateTime);
		fields.setEnabled(MyExample3267DTO_.customFieldColorCheckbox);
		fields.setEnabled(MyExample3267DTO_.customFieldColorDate);
		fields.setEnabled(MyExample3267DTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumValues(MyExample3267DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.setEnabled(MyExample3267DTO_.customFieldColorDictionary);
		fields.setEnabled(MyExample3267DTO_.customFieldColorFileUploadeId);
		fields.setEnabled(MyExample3267DTO_.customFieldColorFileUploade);
		fields.setEnabled(MyExample3267DTO_.customFieldColorNumber);
		fields.setEnabled(MyExample3267DTO_.customFieldColorPercent);
		fields.setEnabled(MyExample3267DTO_.customFieldColorMoney);
		fields.setEnumValues(MyExample3267DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.setEnabled(MyExample3267DTO_.customFieldColorRadio);
		fields.setEnabled(MyExample3267DTO_.customFieldColorPicklistId);
		fields.setEnabled(MyExample3267DTO_.customFieldColorPicklist);
		fields.setEnabled(MyExample3267DTO_.customFieldColorInlinePicklistId);
		fields.setEnabled(MyExample3267DTO_.customFieldColorInlinePicklist);
		fields.setEnabled(MyExample3267DTO_.customFieldColorMultivalue);
		fields.setEnabled(MyExample3267DTO_.customFieldColorMultivalueHover);
		fields.setEnabled(MyExample3267DTO_.customField);
		fields.setRequired(MyExample3267DTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3267DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3267DTO_.customFieldColorInput);
		fields.enableFilter(MyExample3267DTO_.customFieldColorText);
		fields.enableFilter(MyExample3267DTO_.customFieldColorDateTime);
		fields.enableFilter(MyExample3267DTO_.customFieldColorCheckbox);
		fields.enableFilter(MyExample3267DTO_.customFieldColorDate);
		fields.enableFilter(MyExample3267DTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, MyExample3267DTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.enableFilter(MyExample3267DTO_.customFieldColorDictionary);
		fields.enableFilter(MyExample3267DTO_.customFieldColorFileUploade);
		fields.enableFilter(MyExample3267DTO_.customFieldColorNumber);
		fields.enableFilter(MyExample3267DTO_.customFieldColorPercent);
		fields.enableFilter(MyExample3267DTO_.customFieldColorMoney);
		fields.setEnumFilterValues(fields, MyExample3267DTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.enableFilter(MyExample3267DTO_.customFieldColorRadio);
		fields.enableFilter(MyExample3267DTO_.customFieldColorPicklist);
		fields.enableFilter(MyExample3267DTO_.customFieldColorInlinePicklist);
		fields.enableFilter(MyExample3267DTO_.customFieldColorMultivalue);
		fields.enableFilter(MyExample3267DTO_.customFieldColorMultivalueHover);
	}

}