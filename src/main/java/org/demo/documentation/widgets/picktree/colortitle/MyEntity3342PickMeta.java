package org.demo.documentation.widgets.picktree.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorDictionaryEnum;
import org.demo.documentation.widgets.picktree.colortitle.enums.CustomFieldColorRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3342PickMeta extends FieldMetaBuilder<MyEntity3342PickDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3342PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorText);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorInput);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorTextConst);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorInputConst);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorDateTime);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorCheckbox);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorDate);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumValues(MyEntity3342PickDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorDictionary);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorFileUploadeId);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorFileUploade);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorFileUploadeId);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorFileUploade);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorNumber);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorPercent);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorMoney);
		fields.setEnumValues(MyEntity3342PickDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorRadio);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorPicktreeId);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorPicktree);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorInlinePicktreeId);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorInlinePicktree);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorMultivalue);
		fields.setEnabled(MyEntity3342PickDTO_.customFieldColorMultivalueHover);
		fields.setEnabled(MyEntity3342PickDTO_.id);
		fields.setEnabled(MyEntity3342PickDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3342PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3342PickDTO_.parentId);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorText);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorInput);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorTextConst);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorInputConst);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorDateTime);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorCheckbox);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorDate);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorDateTimeWithSeconds);
		fields.setEnumFilterValues(fields, MyEntity3342PickDTO_.customFieldColorDictionary, CustomFieldColorDictionaryEnum.values());
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorDictionary);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorFileUploade);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorFileUploade);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorNumber);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorPercent);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorMoney);
		fields.setEnumFilterValues(fields, MyEntity3342PickDTO_.customFieldColorRadio, CustomFieldColorRadioEnum.values());
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorRadio);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorPicktree);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorInlinePicktree);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorMultivalue);
		fields.enableFilter(MyEntity3342PickDTO_.customFieldColorMultivalueHover);

		fields.enableSort(MyEntity3342PickDTO_.customFieldColorText);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorInput);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorTextConst);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorInputConst);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorDateTime);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorCheckbox);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorDate);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorDateTimeWithSeconds);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorDictionary);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorFileUploade);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorFileUploade);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorNumber);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorPercent);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorMoney);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorRadio);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorPicktree);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorInlinePicktree);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorMultivalue);
		fields.enableSort(MyEntity3342PickDTO_.customFieldColorMultivalueHover);

	}

}
