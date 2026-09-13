package org.demo.documentation.fields.picktree.validationconfirm;

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
public class MyEntity3293PickPickTreeMeta extends FieldMetaBuilder<MyEntity3293PickDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3293PickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.fields.picktree.validationconfirm.MyEntity3293PickDTO_.id);
		fields.setEnabled(org.demo.documentation.fields.picktree.validationconfirm.MyEntity3293PickDTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3293PickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3293PickDTO_.parentId);
		fields.enableFilter(MyEntity3293PickDTO_.customField);
		fields.enableSort(MyEntity3293PickDTO_.customField);
		fields.enableSort(MyEntity3293PickDTO_.id);

	}
	// --8<-- [end:buildIndependentMeta]
}
