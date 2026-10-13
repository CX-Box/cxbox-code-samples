package org.demo.documentation.feature.file.availability;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.file.availability.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyExample6105Meta extends FieldMetaBuilder<MyExample6105DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6105DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample6105DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnabled(MyExample6105DTO_.customFieldDictionary);
		fields.setEnabled(MyExample6105DTO_.customFieldFileId);
		fields.setEnabled(MyExample6105DTO_.customFieldFile);
		fields.setEnabled(MyExample6105DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6105DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setEnumFilterValues(fields, MyExample6105DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample6105DTO_.customFieldDictionary);
		fields.enableFilter(MyExample6105DTO_.customFieldFile);
		fields.setFileAccept(MyExample6105DTO_.customFieldFile, List.of(".png", ".pdf", ".jpg", ".jpeg"));
	}

}
