package org.demo.documentation.fields.input.drilldown;


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
public class InputDrilldownMeta extends FieldMetaBuilder<InputDrilldownDTO> {

	private final DocumentConfig configuration;

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<InputDrilldownDTO> fields, InnerBcDescription bcDescription,
									  Long id, Long parentId) {
		fields.setEnabled(InputDrilldownDTO_.customField2);
		fields.setEnabled(
				InputDrilldownDTO_.customField
		);
		fields.setRequired(
				InputDrilldownDTO_.customField
		);
		fields.setDrilldown(
				InputDrilldownDTO_.customField,
				DrillDownType.INNER,
				"/screen/InputDrilldown/view/InputDrilldownform/" + CxboxInputDrilldownController.InputDrilldown + "/" + id
		);
		fields.setDrilldown(
				InputDrilldownDTO_.customField2,
				DrillDownType.INNER,
				"/screen/InputDrilldown/view/InputDrilldowninfo/" + CxboxInputDrilldownController.InputDrilldown + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	// --8<-- [start:buildIndependentMeta]
	@Override
	public void buildIndependentMeta(FieldsMeta<InputDrilldownDTO> fields, InnerBcDescription bcDescription,
									 Long parentId) {
		fields.enableFilter(InputDrilldownDTO_.customField2);
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(InputDrilldownDTO_.customField);
		}
	}

}
