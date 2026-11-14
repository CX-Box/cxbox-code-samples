package org.demo.documentation.feature.drilldown.drilldownfilter;

import lombok.Getter;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.springframework.stereotype.Service;


@Service
public class MyExample4300DashboardStatsService
		extends AnySourceVersionAwareResponseService<MyExample4300DashboardStatsDTO, MyExample4300DashboardStatsDTO> {
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300DashboardStatsMeta> meta = MyExample4300DashboardStatsMeta.class;
	@Getter(onMethod_ = @Override)
	private final Class<MyExample4300DashboardStatsDao> dao = MyExample4300DashboardStatsDao.class;

	@Override
	protected CreateResult<MyExample4300DashboardStatsDTO> doCreateEntity(MyExample4300DashboardStatsDTO entity, BusinessComponent bc) {
		throw new UnsupportedOperationException("Read only stats");
	}

	@Override
	protected ActionResultDTO<MyExample4300DashboardStatsDTO> doUpdateEntity(MyExample4300DashboardStatsDTO entity,
																			 MyExample4300DashboardStatsDTO data, BusinessComponent bc) {
		return new ActionResultDTO<>(entity);
	}
}
