package org.demo.documentation.widgets.assoctree.actions;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3331MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3331MultiMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3331MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3331MultiMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3331MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3331MultiMultivalueDTO_.parentId);
		fields.enableSort(MyEntity3331MultiMultivalueDTO_.id);
		fields.enableSort(MyEntity3331MultiMultivalueDTO_.customField);

	}

}
