package org.demo.documentation.widgets.emptywidget.fieldslayoute;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5032Meta extends FieldMetaBuilder<MyExample5032DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5032DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample5032DTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5032DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}