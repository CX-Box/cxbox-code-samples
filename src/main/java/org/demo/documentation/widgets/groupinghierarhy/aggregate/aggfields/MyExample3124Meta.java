package org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.aggregate.aggfields.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3124Meta extends FieldMetaBuilder<MyExample3124DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3124DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3124DTO_.customFieldNumberOther);
		fields.setEnabled(MyExample3124DTO_.customFieldNumber);
		fields.setEnumValues(MyExample3124DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3124DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3124DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3124DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3124DTO_.customFieldNumberOther);
		fields.enableFilter(MyExample3124DTO_.customFieldNumber);
		fields.setEnumFilterValues(fields, MyExample3124DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3124DTO_.customFieldDictionary);
	}

}