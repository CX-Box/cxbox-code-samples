package org.demo.documentation.widgets.calendarlist.actions.create.newview;

import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.springframework.stereotype.Service;

@Service
public class MyExample5062Meta extends FieldMetaBuilder<MyExample5062DTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5062DTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(MyExample5062DTO_.customField);
		fields.setEnabled(MyExample5062DTO_.startDateTime);
		fields.setEnabled(MyExample5062DTO_.endDateTime);
		fields.setRequired(MyExample5062DTO_.customField);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5062DTO> fields, InnerBcDescription bcDescription, Long parentId) {
		fields.enableFilter(MyExample5062DTO_.customField);
	}

}
