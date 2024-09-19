package org.demo.documentation.fields.multivalue.drilldown;

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
public class MyEntity183MultivalueMeta extends FieldMetaBuilder<MyEntity183MultivalueDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity183MultivalueDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.multivalue.drilldown.MyEntity183MultivalueDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.multivalue.drilldown.MyEntity183MultivalueDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity183MultivalueDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableFilter(MyEntity183MultivalueDTO_.customField);
		fields.enableSort(MyEntity183MultivalueDTO_.customField);
		fields.enableSort(MyEntity183MultivalueDTO_.id);
	}

}
