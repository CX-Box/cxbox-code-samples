package org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.repository.metabuilder.buildrowdependentmeta.sethidden.basic.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class MyExample5010Meta extends FieldMetaBuilder<MyExample5010DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5010DTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		if (fields.isFieldChangedNow(fields, MyExample5010DTO_.customField)) {
			if (Objects.equals(fields.getCurrentValue(MyExample5010DTO_.customField).orElse(null), CustomFieldEnum.HIGH)) {
				fields.setHidden(MyExample5010DTO_.customFieldHidden);
			}
		}

		fields.setEnabled(MyExample5010DTO_.customFieldHidden);
		fields.setEnumValues(MyExample5010DTO_.customField, CustomFieldEnum.values());
		fields.setEnabled(MyExample5010DTO_.customField);

	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5010DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5010DTO_.customFieldHidden);
		fields.setEnumFilterValues(fields, MyExample5010DTO_.customField, CustomFieldEnum.values());
		fields.enableFilter(MyExample5010DTO_.customField);
		fields.setForceActive(MyExample5010DTO_.customField);
	}

}