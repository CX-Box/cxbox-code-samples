package org.demo.documentation.widgets.tree.allType;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class Myexample3262PickPickMeta extends FieldMetaBuilder<Myexample3262PickPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3262PickPickDTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.tree.allType.Myexample3262PickPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.tree.allType.Myexample3262PickPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3262PickPickDTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {

	}

}
