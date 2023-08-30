package org.demo.documentation.fileupload.drilldown;

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
public class MyExample98Meta extends FieldMetaBuilder<MyExample98DTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample98DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample98DTO_.customFieldId);
		fields.setEnabled(MyExample98DTO_.customField);
		fields.setDrilldown(
				MyExample98DTO_.customField,
				DrillDownType.INNER,
				"/screen/myexample98/view/myexample98form/" + PlatformMyExample98Controller.myExampleBc98 + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample98DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample98DTO_.customField);
		}
		fields.enableFilter(MyExample98DTO_.customField);
	}

}