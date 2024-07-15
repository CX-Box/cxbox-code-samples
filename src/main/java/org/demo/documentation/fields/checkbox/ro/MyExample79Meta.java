package org.demo.documentation.fields.checkbox.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.checkbox.ro.MyExample79DTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample79Meta extends FieldMetaBuilder<MyExample79DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample79DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample79DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample79DTO_.customField);
		}
		fields.enableFilter(MyExample79DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}