package org.demo.documentation.widgets.picktree.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3343MultiPickMeta extends FieldMetaBuilder<MyEntity3343MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3343MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picktree.base.allfields.MyEntity3343MultiPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.picktree.base.allfields.MyEntity3343MultiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3343MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3343MultiPickDTO_.parentId);

	}

}
