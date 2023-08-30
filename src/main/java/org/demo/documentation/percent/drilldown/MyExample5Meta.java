package org.demo.documentation.percent.drilldown;

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
public class MyExample5Meta extends FieldMetaBuilder<MyExample5DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				MyExample5DTO_.customField
		);
		fields.setRequired(
				MyExample5DTO_.customField
		);
		fields.setDrilldown(
				MyExample5DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample5/view/myexample5form/" + PlatformMyExample5Controller.myExampleBc5 + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample5DTO_.customField);
		}
		//
	}


}