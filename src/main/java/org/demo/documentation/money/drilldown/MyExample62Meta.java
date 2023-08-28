package org.demo.documentation.money.drilldown;

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
public class MyExample62Meta extends FieldMetaBuilder<MyExample62DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:drilldown]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample62DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample62DTO_.customField);
		fields.setDrilldown(
				MyExample62DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample62/view/myexample62info/" + PlatformMyExample62Controller.myExampleBc62 + "/" + id
		);
	}
	// --8<-- [end:drilldown]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample62DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample62DTO_.customField);
		}
		fields.enableFilter(MyExample62DTO_.customField);
	}

}