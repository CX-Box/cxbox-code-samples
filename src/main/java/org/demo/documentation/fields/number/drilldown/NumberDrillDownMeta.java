package org.demo.documentation.fields.number.drilldown;

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
public class NumberDrillDownMeta extends FieldMetaBuilder<NumberDrillDownDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<NumberDrillDownDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(
				NumberDrillDownDTO_.customField
		);
		fields.setRequired(
				NumberDrillDownDTO_.customField
		);
		fields.setDrilldown(
				NumberDrillDownDTO_.customField,
				DrillDownType.INNER,
				"/screen/NumberDrillDown/view/NumberDrillDownform/" + CxboxNumberDrillDownController.numberDrillDown + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<NumberDrillDownDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(NumberDrillDownDTO_.customField);
		}
	}
	// --8<-- [end:buildIndependentMeta]


}