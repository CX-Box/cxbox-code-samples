package org.demo.documentation.widgets.groupinghierarhy.base.allfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3202PickPick0Meta extends FieldMetaBuilder<MyEntity3202PickPick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3202PickPick0DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202PickPick0DTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.groupinghierarhy.base.allfields.MyEntity3202PickPick0DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3202PickPick0DTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
