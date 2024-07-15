package org.demo.documentation.fields.multipleselect.validationdynamic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.multipleselect.validationconfirm.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MyExample334Meta extends FieldMetaBuilder<MyExample334DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample334DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setDictionaryTypeWithCustomValues(MyExample334DTO_.customField, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.toArray(String[]::new));
		fields.setDictionaryTypeWithCustomValues(MyExample334DTO_.customFieldAdditional, Arrays.stream(CustomFieldEnum.values())
				.map(CustomFieldEnum::getValue)
				.toArray(String[]::new));
		fields.setEnabled(MyExample334DTO_.customField);
		fields.setEnabled(MyExample334DTO_.customFieldAdditional);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample334DTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
	}

}