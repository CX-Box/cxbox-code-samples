package org.demo.documentation.radio.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.radio.drilldown.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample24Meta extends FieldMetaBuilder<MyExample24DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample24DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample24DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample24DTO_.customField);
		fields.setDrilldown(
				MyExample24DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample24/view/myexample24info/" + PlatformMyExample24Controller.myExampleBc24 + "/" + id
		);

	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample24DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample24DTO_.customField);
		}
		fields.setEnumFilterValues(fields, MyExample24DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample24DTO_.customField);
	}

}