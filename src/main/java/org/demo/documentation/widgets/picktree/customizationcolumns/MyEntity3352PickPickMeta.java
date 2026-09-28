package org.demo.documentation.widgets.picktree.customizationcolumns;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3352PickPickMeta extends FieldMetaBuilder<MyEntity3352PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3352PickPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.picktree.customizationcolumns.MyEntity3352PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3352PickPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(MyEntity3352PickPickDTO_.parentId);

	}

}
