package org.demo.documentation.widgets.tree.any.data.departments;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class My3261UsersPickMeta extends FieldMetaBuilder<My3261UsersPickDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<My3261UsersPickDTO> fields, InnerBcDescription bcDescription,
	                                  Long id, Long parentId) {
		fields.setEnabled(org.demo.documentation.widgets.tree.any.data.departments.My3261UsersPickDTO_.id);
		fields.setEnabled(org.demo.documentation.widgets.tree.any.data.departments.My3261UsersPickDTO_.lastName);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<My3261UsersPickDTO> fields, InnerBcDescription bcDescription,
	                                 Long parentId) {

	}

}
