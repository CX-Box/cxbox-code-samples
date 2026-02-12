package org.demo.documentation.fields.datetimewithseconds.ro;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeWithSecondsCreateEditMeta extends FieldMetaBuilder<DateTimeWithSecondsCreateEditDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeWithSecondsCreateEditDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		//
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeWithSecondsCreateEditDTO> fields,
									 InnerBcDescription bcDescription, Long parentId) {
		//
	}


}