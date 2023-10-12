package org.demo.documentation.datetime.drilldown;

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
public class DateTimeDrilldownMeta extends FieldMetaBuilder<DateTimeDrilldownDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<DateTimeDrilldownDTO> fields,
			InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				DateTimeDrilldownDTO_.customField
		);
		fields.setRequired(
				DateTimeDrilldownDTO_.customField
		);

		fields.setDrilldown(
				DateTimeDrilldownDTO_.customField,
				DrillDownType.INNER,
				"/screen/DateTimeDrilldown/view/DateTimeDrilldownform/" + CxboxDateTimeDrilldownController.dateTimeDrilldown
						+ "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<DateTimeDrilldownDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(DateTimeDrilldownDTO_.customField);
		}
		//
	}


}