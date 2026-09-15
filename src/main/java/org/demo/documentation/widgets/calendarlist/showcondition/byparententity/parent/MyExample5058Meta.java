package org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5058Meta extends FieldMetaBuilder<MyExample5058DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5058DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5058DTO_.customField);
		fields.setEnabled(MyExample5058DTO_.startDateTime);
		fields.setEnabled(MyExample5058DTO_.endDateTime);
		fields.setEnabled(MyExample5058DTO_.customFieldNumber);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5058DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5058DTO_.customField);
	}

}
