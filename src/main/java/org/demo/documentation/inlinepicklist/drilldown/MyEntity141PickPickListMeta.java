package org.demo.documentation.inlinepicklist.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@RequiredArgsConstructor
@Service
public class MyEntity141PickPickListMeta extends FieldMetaBuilder<MyEntity141PickDTO> {

	private final DocumentConfig configuration;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity141PickDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.inlinepicklist.drilldown.MyEntity141PickDTO_.id);
		fields.setEnabled(org.demo.documentation.inlinepicklist.drilldown.MyEntity141PickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity141PickDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {

//
	}

}
