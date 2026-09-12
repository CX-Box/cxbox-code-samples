package org.demo.documentation.fields.picktree.filtration;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyExample3286Meta extends FieldMetaBuilder<MyExample3286DTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3286DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3286DTO_.customFieldId);
		fields.setEnabled(MyExample3286DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3286DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(MyExample3286DTO_.customField);
		}
		fields.enableFilter(MyExample3286DTO_.customField);
		fields.enableSort(MyExample3286DTO_.customField);
	}
	// --8<-- [end:buildIndependentMeta]
}