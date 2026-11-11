package org.demo.documentation.feature.scheduler.admin.stats;

import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.demo.documentation.feature.scheduler.CxboxMyExample5262Controller;
import org.springframework.stereotype.Service;

@Service
public class MyExample5262JobStatsMeta extends AnySourceFieldMetaBuilder<MyExample5262JobStatsDTO> {

	// --8<-- [start:buildRowDependentMeta]
	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample5262JobStatsDTO> fields, BcDescription bc,
			String id, String parentId) {
		fields.setDrilldown(
				MyExample5262JobStatsDTO_.value,
				DrillDownType.INNER,
				"/screen/myexample5262/view/myexample5262jobs/" + CxboxMyExample5262Controller.myexample5262jobstats + "/" + id
		);
	}
	// --8<-- [end:buildRowDependentMeta]

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample5262JobStatsDTO> fields, BcDescription bcDescription,
			String parentId) {
	}

}
