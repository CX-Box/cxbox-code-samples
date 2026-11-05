package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.impl.BcDescription;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.FieldsMeta;
import org.cxbox.core.dto.rowmeta.RowDependentFieldsMeta;
import org.cxbox.core.service.rowmeta.AnySourceFieldMetaBuilder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyExample4300DashboardStatsMeta extends AnySourceFieldMetaBuilder<MyExample4300DashboardStatsDTO> {
	private final MyEntity4300PostActionWithCustomBuilderRepository formRepository;

	@Override
	public void buildRowDependentMeta(RowDependentFieldsMeta<MyExample4300DashboardStatsDTO> fields,
									  BcDescription bc, String id, String parentId) {
		if (!"matching".equals(id)) {
			return;
		}
		var dto = new MyExample4300PostActionWithCustomBuilderDTO(formRepository.findById(Long.valueOf(parentId)).orElseThrow());
		if (MyExample4300DashboardFilters.isEmpty(dto)) {
			return;
		}
		fields.setDrilldownWithFilter(MyExample4300DashboardStatsDTO_.value, DrillDownType.INNER,
				MyExample4300DashboardFilters.VIEW,
				fc -> fc.add(CxboxMyExample4300Controller.myExample4300DrillDown, MyExample4300WithDrilldownDTO.class,
						fb -> MyExample4300DashboardFilters.apply(fb, dto)));
	}

	@Override
	public void buildIndependentMeta(FieldsMeta<MyExample4300DashboardStatsDTO> fields, BcDescription bc, String parentId) {
	}
}
