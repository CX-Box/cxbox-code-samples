package org.demo.documentation.widgets.cardlist.showcondition.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5303Meta extends FieldMetaBuilder<MyExample5303DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5303DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5303DTO_.customFieldNumber);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5303DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
