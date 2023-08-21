package org.demo.documentation.input.drilldown;


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

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<InputDrilldownDTO> fields, InnerBcDescription bcDescription,
			Long id, Long parentId) {
		fields.setEnabled(
				InputDrilldownDTO_.customField
		);
		fields.setRequired(
				InputDrilldownDTO_.customField
		);
		fields.setDrilldown(
				InputDrilldownDTO_.customField,
				DrillDownType.INNER,
				"/screen/InputDrilldown/view/InputDrilldowninfo/" + CxboxInputDrilldownController.InputDrilldown + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<InputDrilldownDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		if (configuration.getForceActiveEnabled()) {
			fields.setForceActive(InputDrilldownDTO_.customField);
		}
	}

}
