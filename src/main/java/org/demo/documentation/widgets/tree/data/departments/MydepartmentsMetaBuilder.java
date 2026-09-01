package org.demo.documentation.widgets.tree.data.departments;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MydepartmentsMetaBuilder extends FieldMetaBuilder<MydepartmentsDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MydepartmentsDTO> fields, InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(MydepartmentsDTO_.fullName);
		fields.setEnabled(MydepartmentsDTO_.parentId);
		fields.setEnabled(MydepartmentsDTO_.description);
		fields.setEnabled(MydepartmentsDTO_.departmentName);
		fields.setEnabled(
				MydepartmentsDTO_.id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MydepartmentsDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MydepartmentsDTO_.fullName);
		fields.enableFilter(MydepartmentsDTO_.parentId);
		fields.enableFilter(MydepartmentsDTO_.description);
		fields.enableFilter(MydepartmentsDTO_.departmentName);
		fields.enableFilter(
				MydepartmentsDTO_.id
		);
		fields.enableSort(
				MydepartmentsDTO_.id
		);
	}

}
