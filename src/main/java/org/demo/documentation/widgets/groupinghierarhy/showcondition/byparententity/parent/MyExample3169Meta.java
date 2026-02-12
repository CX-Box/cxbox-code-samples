package org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.showcondition.byparententity.parent.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3169Meta extends FieldMetaBuilder<MyExample3169DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3169DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3169DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3169DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3169DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumValues(MyExample3169DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumFilterValues(fields, MyExample3169DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3169DTO_.customFieldDictionary);
	}

}