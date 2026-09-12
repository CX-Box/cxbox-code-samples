package org.demo.documentation.fields.picktree.drilldown;

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
public class MyExample3285Meta extends FieldMetaBuilder<MyExample3285DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3285DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3285DTO_.customFieldId);
		fields.setEnabled(MyExample3285DTO_.customField);
		fields.setDrilldown(
				MyExample3285DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample3285/view/myexample3285form/" + PlatformMyExample3285Controller.myExampleBc3285 + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3285DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3285DTO_.customField);
		}
		fields.enableFilter(MyExample3285DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}