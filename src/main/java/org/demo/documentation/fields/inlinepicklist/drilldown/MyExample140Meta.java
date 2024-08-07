package org.demo.documentation.fields.inlinepicklist.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample140Meta extends FieldMetaBuilder<MyExample140DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample140DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample140DTO_.customFieldId);
		fields.setEnabled(MyExample140DTO_.customField);
		fields.setDrilldown(
				MyExample140DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample140/view/myexample140form/" + PlatformMyExample140Controller.myExampleBc140 + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample140DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample140DTO_.customField);
		}
		fields.enableFilter(MyExample140DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}