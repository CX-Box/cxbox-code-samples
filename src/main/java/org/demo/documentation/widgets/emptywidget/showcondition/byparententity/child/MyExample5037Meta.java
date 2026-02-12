package org.demo.documentation.widgets.emptywidget.showcondition.byparententity.child;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5037Meta extends FieldMetaBuilder<MyExample5037DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5037DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5037DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5037DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}