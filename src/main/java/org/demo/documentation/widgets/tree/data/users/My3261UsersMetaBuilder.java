package org.demo.documentation.widgets.tree.data.users;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class My3261UsersMetaBuilder extends FieldMetaBuilder<My3261UsersDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<My3261UsersDTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(My3261UsersDTO_.middleName);
		fields.setEnabled(My3261UsersDTO_.firstName);
		fields.setEnabled(My3261UsersDTO_.lastName);
		fields.setEnabled(
				org.demo.documentation.widgets.tree.any.data.users.My3261UsersDTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<My3261UsersDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(My3261UsersDTO_.middleName);
		fields.enableFilter(My3261UsersDTO_.firstName);
		fields.enableFilter(My3261UsersDTO_.lastName);
		fields.enableFilter(
				org.demo.documentation.widgets.tree.any.data.users.My3261UsersDTO_.id
		);
		fields.enableSort(
				org.demo.documentation.widgets.tree.any.data.users.My3261UsersDTO_.id
		);
	}

}
