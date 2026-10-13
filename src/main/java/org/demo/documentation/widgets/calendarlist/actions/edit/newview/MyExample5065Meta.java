package org.demo.documentation.widgets.calendarlist.actions.edit.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5065Meta extends FieldMetaBuilder<MyExample5065DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5065DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5065DTO_.customField);
		fields.setEnabled(MyExample5065DTO_.startDateTime);
		fields.setEnabled(MyExample5065DTO_.endDateTime);
		fields.setRequired(MyExample5065DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5065DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5065DTO_.customField);
	}

}
