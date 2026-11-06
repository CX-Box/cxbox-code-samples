package org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryEnum;
import org.demo.documentation.widgets.groupinghierarhy.defaultgroupinghierarchy.dynamic.enums.CustomFieldDictionaryLevelTwoEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample3296ConfigMeta extends FieldMetaBuilder<MyExample3296ConfigDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3296ConfigDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnumValues(MyExample3296ConfigDTO_.customFieldDictionary, CustomFieldDictionaryEnum.values());
		fields.setEnumValues(
				MyExample3296ConfigDTO_.customFieldDictionaryLevelTwo,
				CustomFieldDictionaryLevelTwoEnum.values()
		);
		fields.setEnabled(
				MyExample3296ConfigDTO_.customFieldDictionary,
				MyExample3296ConfigDTO_.customFieldDictionaryLevelTwo,
				MyExample3296ConfigDTO_.defaultExpanded
		);
		fields.setRequired(MyExample3296ConfigDTO_.customFieldDictionary);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3296ConfigDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}
