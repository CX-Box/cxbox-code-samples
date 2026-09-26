package org.demo.documentation.widgets.column2d.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4276FormMeta extends FieldMetaBuilder<MyExample4276FormDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4276FormDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExample4276FormDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4276FormDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}
