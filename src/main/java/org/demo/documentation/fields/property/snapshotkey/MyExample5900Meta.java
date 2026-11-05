package org.demo.documentation.fields.property.snapshotkey;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.fields.property.snapshotkey.enums.CustomFieldEnum;
import org.springframework.stereotype.Service;

@SuppressWarnings("EmptyMethod")
@Service
public class MyExample5900Meta extends FieldMetaBuilder<MyExample5900DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5900DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnumValues(MyExample5900DTO_.dictionaryField, CustomFieldEnum.values());
		fields.setEnumValues(MyExample5900DTO_.radioField, CustomFieldEnum.values());
		fields.setEnabled(
				MyExample5900DTO_.inputField,
				MyExample5900DTO_.textField,
				MyExample5900DTO_.numberField,
				MyExample5900DTO_.moneyField,
				MyExample5900DTO_.percentField,
				MyExample5900DTO_.dateField,
				MyExample5900DTO_.dateTimeField,
				MyExample5900DTO_.dateTimeWithSecondsField,
				MyExample5900DTO_.checkboxField,
				MyExample5900DTO_.pickListField,
				MyExample5900DTO_.pickListFieldId,
				MyExample5900DTO_.inlinePickListField,
				MyExample5900DTO_.inlinePickListFieldId,
				MyExample5900DTO_.dictionaryField,
				MyExample5900DTO_.radioField
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5900DTO> fields, InnerBcDescription bcDescription, Long parentId) {

	}

}
