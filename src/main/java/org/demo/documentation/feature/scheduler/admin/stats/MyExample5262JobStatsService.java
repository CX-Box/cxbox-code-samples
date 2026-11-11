package org.demo.documentation.feature.scheduler.admin.stats;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.AnySourceVersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.scheduler.CxboxMyExample5262Controller;
import org.springframework.stereotype.Service;

@SuppressWarnings({"java:S1170", "java:S2387"})
@RequiredArgsConstructor
@Service
public class MyExample5262JobStatsService extends
		AnySourceVersionAwareResponseService<MyExample5262JobStatsDTO, MyExample5262JobStatsDTO> {

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5262JobStatsMeta> meta = MyExample5262JobStatsMeta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5262JobStatsDao> dao = MyExample5262JobStatsDao.class;

	@Override
	protected CreateResult<MyExample5262JobStatsDTO> doCreateEntity(MyExample5262JobStatsDTO entity,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample5262JobStatsDTO> doUpdateEntity(MyExample5262JobStatsDTO entity,
			MyExample5262JobStatsDTO data, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	public Actions<MyExample5262JobStatsDTO> getActions() {
		return Actions.<MyExample5262JobStatsDTO>builder()
				.action(act -> act
						.action("refresh", "Refresh")
						.invoker((bc, dto) -> new ActionResultDTO<MyExample5262JobStatsDTO>()
								.setAction(PostAction.refreshBc(CxboxMyExample5262Controller.myexample5262jobstats)))
				)
				.build();
	}

}
