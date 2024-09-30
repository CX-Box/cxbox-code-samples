package org.demo.documentation.other.savewithparent.example5.meta;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.InnerBcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.FieldMetaBuilder;
import org.demo.documentation.other.savewithparent.example5.CxboxMyExample5555Controller;
import org.demo.documentation.other.savewithparent.example5.dto.ApplicationEntityDTO;
import org.demo.documentation.other.savewithparent.example5.dto.ApplicationEntityDTO_;
import org.demo.documentation.other.savewithparent.example5.enums.StatusEnum;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApplicationMeta extends FieldMetaBuilder<ApplicationEntityDTO> {

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<ApplicationEntityDTO> fields,
			InnerBcDescription bcDescription, Long id, Long parentId) {
		fields.setEnabled(
				ApplicationEntityDTO_.name,
				ApplicationEntityDTO_.status,
				ApplicationEntityDTO_.createdDate
		);
		fields.setRequired(ApplicationEntityDTO_.name);
		fields.setEnumValues(ApplicationEntityDTO_.status, StatusEnum.values());
		fields.setDrilldown(
				ApplicationEntityDTO_.name,
				DrillDownType.INNER,
				"/screen/autosave/view/details/" + CxboxMyExample5555Controller.application + "/" + id
		);
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<ApplicationEntityDTO> fields, InnerBcDescription bcDescription,
			Long parentId) {
		fields.enableSort(ApplicationEntityDTO_.name);
		fields.enableFilter(ApplicationEntityDTO_.name);
		fields.enableSort(ApplicationEntityDTO_.id);
		fields.enableFilter(ApplicationEntityDTO_.id);
		fields.enableSort(ApplicationEntityDTO_.status);
		fields.enableFilter(ApplicationEntityDTO_.status);
		fields.enableFilter(ApplicationEntityDTO_.createdDate);
		fields.enableSort(ApplicationEntityDTO_.createdDate);
		fields.setForceActive(
				ApplicationEntityDTO_.name,
				ApplicationEntityDTO_.id,
				ApplicationEntityDTO_.status
		);

		fields.setEnumFilterValues(fields, ApplicationEntityDTO_.status, StatusEnum.values());
	}

}
