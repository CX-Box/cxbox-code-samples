package org.demo.documentation.widgets.assoctree.base.forfield;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3330MultiMultivalueMeta extends FieldMetaBuilder<MyEntity3330MultiMultivalueDTO> {

	@Override
	// --8<-- [start:buildRowDependentMeta]
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3330MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3330MultiMultivalueDTO_.customFieldNew);
		fields.setEnabled(MyEntity3330MultiMultivalueDTO_.customField);
	}

	// --8<-- [end:buildRowDependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3330MultiMultivalueDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3330MultiMultivalueDTO_.parentId);
		fields.enableFilter(MyEntity3330MultiMultivalueDTO_.customFieldNew);

	}

}
