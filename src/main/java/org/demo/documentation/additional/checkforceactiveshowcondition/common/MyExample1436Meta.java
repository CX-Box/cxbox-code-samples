package org.demo.documentation.additional.checkforceactiveshowcondition.common;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums.CrsStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample1436Meta extends FieldMetaBuilder<MyExample1436DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample1436DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample1436DTO_.crsStatus, CrsStatusEnum.values());
		fields.setEnabled(MyExample1436DTO_.country, MyExample1436DTO_.tin, MyExample1436DTO_.parentId);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample1436DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
