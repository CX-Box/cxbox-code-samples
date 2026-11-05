package org.demo.documentation.widgets.relationGraph.showcondition;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample6153FormMeta extends FieldMetaBuilder<MyExample6153FormDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6153FormDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample6153FormDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6153FormDTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}
}
