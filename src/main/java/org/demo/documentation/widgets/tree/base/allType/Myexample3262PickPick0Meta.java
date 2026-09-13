package org.demo.documentation.widgets.tree.base.allType;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class Myexample3262PickPick0Meta extends FieldMetaBuilder<Myexample3262PickPick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3262PickPick0DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(Myexample3262PickPick0DTO_.id);
		fields.setEnabled(Myexample3262PickPick0DTO_.customField2);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3262PickPick0DTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {

	}

}
