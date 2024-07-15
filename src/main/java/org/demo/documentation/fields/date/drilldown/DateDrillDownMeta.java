package org.demo.documentation.fields.date.drilldown;

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
public class DateDrillDownMeta extends FieldMetaBuilder<DateDrillDownDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateDrillDownDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateDrillDownDTO_.customField
		);
		fields.setRequired(
				DateDrillDownDTO_.customField
		);
		fields.setDrilldown(
				DateDrillDownDTO_.customField,
				DrillDownType.INNER,
				"/screen/DateDrillDown/view/DateDrillDownform/" + CxboxDateDrillDownController.dateDrillDown + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<DateDrillDownDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateDrillDownDTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]


}