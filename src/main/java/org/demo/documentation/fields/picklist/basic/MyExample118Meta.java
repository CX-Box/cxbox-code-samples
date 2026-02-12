package org.demo.documentation.fields.picklist.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample118Meta extends FieldMetaBuilder<MyExample118DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample118DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample118DTO_.customFieldId);
		fields.setEnabled(MyExample118DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample118DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample118DTO_.customField);
		}
		fields.enableFilter(MyExample118DTO_.customField);
		fields.enableSort(MyExample118DTO_.customFieldId);
		fields.enableFilter(MyExample118DTO_.customFieldId);
		fields.enableSort(MyExample118DTO_.customFieldId);
	}
	// --8<-- [end:buildIndependentMeta]
}