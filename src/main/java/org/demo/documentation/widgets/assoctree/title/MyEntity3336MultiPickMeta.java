package org.demo.documentation.widgets.assoctree.title;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3336MultiPickMeta extends FieldMetaBuilder<MyEntity3336MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3336MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.assoctree.title.MyEntity3336MultiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3336MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3336MultiPickDTO_.parentId);

	}

}
