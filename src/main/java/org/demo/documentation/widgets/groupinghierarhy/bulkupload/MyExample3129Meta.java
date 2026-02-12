package org.demo.documentation.widgets.groupinghierarhy.bulkupload;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.bulkupload.enums.CustomFieldDictionaryEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyExample3129Meta extends FieldMetaBuilder<MyExample3129DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3129DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3129DTO_.customFieldFileId);
		fields.setEnabled(MyExample3129DTO_.customFieldFile);
		fields.setEnabled(MyExample3129DTO_.customFieldDictionary);
		fields.setEnabled(MyExample3129DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3129DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3129DTO_.customFieldFile);
		fields.setEnumValues(MyExample3129DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumFilterValues(fields, MyExample3129DTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.enableFilter(MyExample3129DTO_.customFieldDictionary);
		fields.setFileAccept(MyExample3129DTO_.customFieldFile, List.of(".png", ".pdf", ".jpg", ".jpeg"));
	}

}