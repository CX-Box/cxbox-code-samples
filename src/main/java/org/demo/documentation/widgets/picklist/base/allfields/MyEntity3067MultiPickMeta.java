package org.demo.documentation.widgets.picklist.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3067MultiPickMeta extends FieldMetaBuilder<MyEntity3067MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3067MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picklist.base.allfields.MyEntity3067MultiPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.picklist.base.allfields.MyEntity3067MultiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3067MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
