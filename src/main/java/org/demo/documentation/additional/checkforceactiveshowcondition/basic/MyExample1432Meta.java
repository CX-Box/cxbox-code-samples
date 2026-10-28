package org.demo.documentation.additional.checkforceactiveshowcondition.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums.AccountableCrsEnum;
import org.demo.documentation.additional.checkforceactiveshowcondition.basic.enums.CrsStatusEnum;
import org.springframework.stereotype.Service;

@Service
public class MyExample1432Meta extends FieldMetaBuilder<MyExample1432DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample1432DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample1432DTO_.crsStatus, CrsStatusEnum.values());
		fields.setEnumValues(MyExample1432DTO_.accountableCrs, AccountableCrsEnum.values());
		fields.setEnabled(MyExample1432DTO_.crsStatus, MyExample1432DTO_.accountableCrs);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample1432DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.setForceActive(MyExample1432DTO_.accountableCrs);
	}

}
