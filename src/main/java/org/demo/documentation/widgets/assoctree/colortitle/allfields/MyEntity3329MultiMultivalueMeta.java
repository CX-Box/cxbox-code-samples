package org.demo.documentation.widgets.assoctree.colortitle.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.assoctree.colortitle.allfields.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3329MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3329MultiMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3329MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorInput);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorText);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorDateTime);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorCheckbox);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorDate);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumValues(MyEntity3329MultiMultivalueDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorDictionary);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorFileUploadeId);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorFileUploade);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorNumber);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorPercent);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorMoney);
		fields.setEnumValues(MyEntity3329MultiMultivalueDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorRadio);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorPicklistId);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorPicklist);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorInlinePicklistId);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorInlinePicklist);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorMultivalue);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customFieldColorMultivalueHover);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.id);
		fields.setEnabled(MyEntity3329MultiMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3329MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorInput);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorText);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorDateTime);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorCheckbox);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorDate);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, MyEntity3329MultiMultivalueDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorDictionary);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorFileUploade);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorNumber);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorPercent);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorMoney);
		fields.setEnumFilterValues(fields, MyEntity3329MultiMultivalueDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorRadio);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorPicklist);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorInlinePicklist);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorMultivalue);
		fields.enableFilter(MyEntity3329MultiMultivalueDTO_.customFieldColorMultivalueHover);

	}

}
