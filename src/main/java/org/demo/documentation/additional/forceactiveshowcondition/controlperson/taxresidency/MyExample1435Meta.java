package org.demo.documentation.additional.forceactiveshowcondition.controlperson.taxresidency;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample1435Meta extends FieldMetaBuilder<MyExample1435DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample1435DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample1435DTO_.country, MyExample1435DTO_.tin);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample1435DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
