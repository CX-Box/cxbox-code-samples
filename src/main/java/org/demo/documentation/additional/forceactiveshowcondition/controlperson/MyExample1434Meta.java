package org.demo.documentation.additional.forceactiveshowcondition.controlperson;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample1434Meta extends FieldMetaBuilder<MyExample1434DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample1434DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(MyExample1434DTO_.fullName, MyExample1434DTO_.inn);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample1434DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
