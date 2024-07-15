package org.demo.documentation.fields.date.validationconfirm;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.demo.documentation.date.validationconfirm.DateConfirmDTO_;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateConfirmMeta extends FieldMetaBuilder<DateConfirmDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateConfirmDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateConfirmDTO_.customField
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<DateConfirmDTO> fields, InnerBcDescription bcDescription, Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateConfirmDTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]


}