package org.demo.documentation.widgets.tree.showcondition.byparententity.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample3270MetaBuilder extends FieldMetaBuilder<Myexample3270DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3270DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3270DTO_.departments);
		fields.setEnabled(Myexample3270DTO_.departmentId);
		fields.setEnabled(Myexample3270DTO_.department);
		fields.setEnabled(
				Myexample3270DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3270DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3270DTO_.departments);
		fields.enableFilter(Myexample3270DTO_.department);
		fields.enableFilter(
				Myexample3270DTO_.id
		);
		fields.enableSort(
				Myexample3270DTO_.id
		);
	}

}
