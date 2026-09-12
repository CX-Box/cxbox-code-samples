package org.demo.documentation.fields.picktree.filtration;

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
public class MyEntity3286PickPickTreeMeta extends FieldMetaBuilder<MyEntity3286PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3286PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3286PickDTO_.customFieldAdditional);
		fields.setEnabled(org.demo.documentation.fields.picktree.filtration.MyEntity3286PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.picktree.filtration.MyEntity3286PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3286PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3286PickDTO_.parentId);
		fields.enableFilter(MyEntity3286PickDTO_.customFieldAdditional);
		fields.enableSort(MyEntity3286PickDTO_.customFieldAdditional);
		fields.enableSort(MyEntity3286PickDTO_.customField);
		fields.enableSort(MyEntity3286PickDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]
}
