package org.demo.documentation.widgets.tree.base.allType;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class Myexample3262MultiPickMeta extends FieldMetaBuilder<Myexample3262MultiPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3262MultiPickDTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(Myexample3262MultiPickDTO_.id);
		fields.setEnabled(Myexample3262MultiPickDTO_.customField);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3262MultiPickDTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {

	}

}
