package org.demo.documentation.widgets.assoctree.actions.other.createwithparent.assoc;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3339MultivalueMeta extends FieldMetaBuilder<MyEntity3339MultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3339MultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3339MultivalueDTO_.customFieldText);
		fields.setEnabled(MyEntity3339MultivalueDTO_.id);
		fields.setEnabled(MyEntity3339MultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3339MultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3339MultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3339MultivalueDTO_.customFieldText);
		fields.enableSort(MyEntity3339MultivalueDTO_.customFieldText);
		fields.enableSort(MyEntity3339MultivalueDTO_.id);
		fields.enableSort(MyEntity3339MultivalueDTO_.customField);

	}

}
