package org.demo.documentation.widgets.picktree.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample3341Meta extends FieldMetaBuilder<MyExample3341DTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample3341DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample3341DTO_.customFieldPicktreeColorConstId);
		fields.setEnabled(MyExample3341DTO_.customFieldPicktreeColorConst);
		fields.setEnabled(MyExample3341DTO_.customFieldPicktreeId);
		fields.setEnabled(MyExample3341DTO_.customFieldPicktree);

	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample3341DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample3341DTO_.customFieldPicktreeColorConst);
		fields.enableFilter(MyExample3341DTO_.customFieldPicktree);
	}

}