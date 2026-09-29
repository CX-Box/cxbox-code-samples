package org.demo.documentation.widgets.pie1d.showcondition.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample4215ParentMeta extends FieldMetaBuilder<MyExample4215ParentDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4215ParentDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MyExample4215ParentDTO_.customFieldNumber);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4215ParentDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}
