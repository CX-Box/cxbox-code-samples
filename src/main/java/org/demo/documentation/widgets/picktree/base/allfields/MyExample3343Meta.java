package org.demo.documentation.widgets.picktree.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.picktree.base.allfields.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.picktree.base.allfields.enums.CustomFieldRadioEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3343Meta extends FieldMetaBuilder<MyExample3343DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3343DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample3343DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3343DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3343DTO_.customFieldFileUploadeId);
		fields.setEnabled(MyExample3343DTO_.customFieldFileUploade);
		fields.setEnumValues(MyExample3343DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.setEnabled(MyExample3343DTO_.customFieldRadio);
		fields.setEnabled(MyExample3343DTO_.customFieldMultivalue);
		fields.setEnabled(MyExample3343DTO_.customFieldInlinePickTreeId);
		fields.setEnabled(MyExample3343DTO_.customFieldInlinePickTree);
		fields.setEnabled(MyExample3343DTO_.customFieldId);
		fields.setEnabled(MyExample3343DTO_.customField);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3343DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, MyExample3343DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3343DTO_.customFieldDictionary);
		fields.enableFilter(MyExample3343DTO_.customFieldFileUploade);
		fields.setEnumFilterValues(fields, MyExample3343DTO_.customFieldRadio, CustomFieldRadioEnum.values());
		fields.enableFilter(MyExample3343DTO_.customFieldRadio);
		fields.enableFilter(MyExample3343DTO_.customFieldMultivalue);
		fields.enableFilter(MyExample3343DTO_.customFieldInlinePickTree);
		fields.enableFilter(MyExample3343DTO_.customField);
		fields.enableSort(MyExample3343DTO_.customFieldId);
		fields.enableSort(MyExample3343DTO_.customField);
	}

}