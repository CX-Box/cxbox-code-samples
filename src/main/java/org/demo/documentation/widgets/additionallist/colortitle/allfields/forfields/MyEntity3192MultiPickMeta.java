package org.demo.documentation.widgets.additionallist.colortitle.allfields.forfields;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyEntity3192MultiPickMeta extends FieldMetaBuilder<MyEntity3192MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyEntity3192MultiPickDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyEntity3192MultiPickDTO_.id);
		fields.setEnabled(MyEntity3192MultiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyEntity3192MultiPickDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {

	}

}
