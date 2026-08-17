package org.demo.documentation.widgets.tree.base.inner;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class Myexample3260MetaBuilder extends FieldMetaBuilder<Myexample3260DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<Myexample3260DTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(Myexample3260DTO_.departments);
		fields.setEnabled(Myexample3260DTO_.departmentId);
		fields.setEnabled(Myexample3260DTO_.department);
		fields.setEnabled(
				Myexample3260DTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<Myexample3260DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(Myexample3260DTO_.departments);
		fields.enableFilter(Myexample3260DTO_.department);
		fields.enableFilter(
				Myexample3260DTO_.id
		);
		fields.enableSort(
				Myexample3260DTO_.id
		);
	}

}
