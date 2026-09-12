package org.demo.documentation.fields.picktree.required;

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
public class MyEntity3288PickPickTreeMeta extends FieldMetaBuilder<MyEntity3288PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3288PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.picktree.required.MyEntity3288PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.picktree.required.MyEntity3288PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3288PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3288PickDTO_.parentId);
		fields.enableFilter(MyEntity3288PickDTO_.customField);
		fields.enableSort(MyEntity3288PickDTO_.customField);
		fields.enableSort(MyEntity3288PickDTO_.id);
	}
	// --8<-- [end:buildIndependentMeta]
}
