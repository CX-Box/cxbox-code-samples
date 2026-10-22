package org.demo.documentation.widgets.line2d.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4242FormMeta extends FieldMetaBuilder<MyExample4242FormDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4242FormDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample4242FormDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4242FormDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}
}
