package org.demo.documentation.widgets.tree;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder; 
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class Myexample3261Pick0Meta extends FieldMetaBuilder<Myexample3261Pick0DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3261Pick0DTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(Myexample3261Pick0DTO_.id);
		fields.setEnabled(Myexample3261Pick0DTO_.department);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3261Pick0DTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {
		fields.enableFilter(Myexample3261Pick0DTO_.parentId);
	}

}
