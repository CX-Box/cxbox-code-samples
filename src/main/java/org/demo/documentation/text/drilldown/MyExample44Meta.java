package org.demo.documentation.text.drilldown;

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
public class MyExample44Meta extends FieldMetaBuilder<MyExample44DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample44DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample44DTO_.customField);
		fields.setDrilldown(
				MyExample44DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample44/view/myexample44info/" + PlatformMyExample44Controller.myExampleBc44 + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample44DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample44DTO_.customField);
		}
		fields.enableFilter(MyExample44DTO_.customField);
		//
	}


}