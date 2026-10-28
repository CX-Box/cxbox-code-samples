package org.demo.documentation.additional.checkforceactiveshowcondition.basic.taxresidency;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample1433Meta extends FieldMetaBuilder<MyExample1433DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample1433DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample1433DTO_.country, MyExample1433DTO_.tin);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample1433DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
