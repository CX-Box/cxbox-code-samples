package org.demo.documentation.fields.date.basic;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.date.basic.DateBasicDTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateBasicMeta extends FieldMetaBuilder<DateBasicDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateBasicDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateBasicDTO_.customField
		);

	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<DateBasicDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateBasicDTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]


}