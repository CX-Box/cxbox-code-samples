package org.demo.documentation.dictionary.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.dictionary.drilldown.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample86Meta extends FieldMetaBuilder<MyExample86DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample86DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample86DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample86DTO_.customField);
		fields.setDrilldown(
				MyExample86DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample86/view/myexampleinfo86/" + PlatformMyExample86Controller.myExampleBc86 + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample86DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample86DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample86DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample86DTO_.customField);
	}

}