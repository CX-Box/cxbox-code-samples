package org.demo.documentation.widgets.groupinghierarhy.actions.create.withwidget;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.actions.create.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3159Meta extends FieldMetaBuilder<MyExample3159DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3159DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3159DTO_.customFieldText);
		fields.setEnabled(MyExample3159DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3159DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3159DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3159DTO_.customFieldText);
		fields.setEnumValues(MyExample3159DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumFilterValues(fields, MyExample3159DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3159DTO_.customFieldDictionary);
	}

}