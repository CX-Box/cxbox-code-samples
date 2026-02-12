package org.demo.documentation.fields.dictionary.icon.assoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3012MultiPickMeta extends FieldMetaBuilder<MyEntity3012MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3012MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3012MultiPickDTO_.id);
		fields.setEnabled(MyEntity3012MultiPickDTO_.customFieldDictionary);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3012MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.setEnumIcons(MyEntity3012MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.iconMap());
		fields.enableFilter(MyEntity3012MultiPickDTO_.customFieldDictionary);
		fields.setEnumFilterValues(fields, MyEntity3012MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumValues(MyEntity3012MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
	}

}
