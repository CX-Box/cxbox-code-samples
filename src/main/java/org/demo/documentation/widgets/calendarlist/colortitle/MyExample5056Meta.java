package org.demo.documentation.widgets.calendarlist.colortitle;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5056Meta extends FieldMetaBuilder<MyExample5056DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5056DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5056DTO_.customField);
		fields.setEnabled(MyExample5056DTO_.startDateTime);
		fields.setEnabled(MyExample5056DTO_.endDateTime);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5056DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5056DTO_.customField);
	}

}
