package org.demo.documentation.fields.dictionary.icon.assoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.dictionary.icon.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3011MultiPickMeta extends FieldMetaBuilder<MyEntity3011MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3011MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3011MultiPickDTO_.id);
		fields.setEnabled(MyEntity3011MultiPickDTO_.customFieldDictionary);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3011MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.setEnumIcons(MyEntity3011MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.iconMap());
		fields.enableFilter(MyEntity3011MultiPickDTO_.customFieldDictionary);
		fields.setEnumFilterValues(fields, MyEntity3011MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumValues(MyEntity3011MultiPickDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
	}

}
