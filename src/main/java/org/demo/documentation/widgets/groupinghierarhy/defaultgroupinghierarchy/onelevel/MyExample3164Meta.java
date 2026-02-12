package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.onelevel.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3164Meta extends FieldMetaBuilder<MyExample3164DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3164DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample3164DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3164DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3164DTO_.customField);
	}

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3164DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, MyExample3164DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3164DTO_.customFieldDictionary);
		fields.defaultGroupingHierarchy(
				MyExample3164DTO_.customFieldDictionary,
				lvl -> lvl
						.add(CustomFieldDictionaryEnum.LEVEL_1_HIGH)
						.add(CustomFieldDictionaryEnum.LEVEL_1_MIDDLE)
		);
	}
	// --8<-- [end:buildIndependentMeta]
}