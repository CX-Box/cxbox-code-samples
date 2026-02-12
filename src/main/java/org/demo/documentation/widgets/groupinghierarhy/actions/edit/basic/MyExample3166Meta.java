package org.demo.documentation.widgets.groupinghierarhy.actions.edit.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.actions.edit.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3166Meta extends FieldMetaBuilder<MyExample3166DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3166DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3166DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3166DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3166DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumValues(MyExample3166DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumFilterValues(fields, MyExample3166DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3166DTO_.customFieldDictionary);
	}

}