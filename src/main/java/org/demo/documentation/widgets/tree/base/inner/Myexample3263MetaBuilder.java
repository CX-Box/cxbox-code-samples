package org.demo.documentation.widgets.tree.base.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample3263MetaBuilder extends FieldMetaBuilder<Myexample3263DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3263DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3263DTO_.departments);
		fields.setEnabled(Myexample3263DTO_.departmentId);
		fields.setEnabled(Myexample3263DTO_.department);
		fields.setEnabled(
				Myexample3263DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3263DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3263DTO_.departments);
		fields.enableFilter(Myexample3263DTO_.department);
		fields.enableFilter(
				Myexample3263DTO_.id
		);
		fields.enableSort(
				Myexample3263DTO_.id
		);
	}

}
