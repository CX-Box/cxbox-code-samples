package org.demo.documentation.fields.datetimewithseconds.drilldown;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.conf.document.DocumentConfig;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DateTimeWithSecondsDrillDownMeta extends FieldMetaBuilder<DateTimeWithSecondsDrillDownDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeWithSecondsDrillDownDTO> fields,
									  InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(
				DateTimeWithSecondsDrillDownDTO_.customField
		);

		fields.setDrilldown(
				DateTimeWithSecondsDrillDownDTO_.customField,
				DrillDownType.INNER,
				"/screen/DateTimeWithSecondsDrillDown/view/DateTimeWithSecondsDrillDownform/"
						+ CxboxDateTimeWithSecondsDrillDownController.dateTimeWithSecondsDrillDown + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeWithSecondsDrillDownDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeWithSecondsDrillDownDTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]


}