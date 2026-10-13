package org.demo.documentation.feature.file.availability;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.feature.file.availability.enums.StatusEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample6104Meta extends FieldMetaBuilder<MyExample6104DTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample6104DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnumValues(MyExample6104DTO_.status, StatusEnum.values());
		fields.setEnabled(MyExample6104DTO_.status);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample6104DTO> fields, InnerBcDescription bcDescription, Long parentId) {
	}

}
