package org.demo.documentation.fields.dictionary.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.fields.dictionary.drilldown.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample86Meta extends FieldMetaBuilder<MyExample86DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample86DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample86DTO_.customField);
		fields.setDrilldown(
				MyExample86DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample86/view/myexample86form/" + PlatformMyExample86Controller.myExampleBc86 + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample86DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample86DTO_.customField);
		}
		fields.setEnumValues(MyExample86DTO_.customField, CustomFieldEnum.values());
		fields.setEnumFilterValues(fields, MyExample86DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample86DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}