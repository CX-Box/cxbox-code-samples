package org.demo.documentation.widgets.property.filtration.filtergrouphiddenfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.property.filtration.filtergrouphiddenfield.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3628Meta extends FieldMetaBuilder<MyExample3628DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3628DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3628DTO_.customFieldCheckbox);
		fields.setEnumValues(MyExample3628DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample3628DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3628DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3628DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3628DTO_.customFieldCheckbox);
		fields.setEnumFilterValues(fields, MyExample3628DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3628DTO_.customFieldDictionary);
	}

}