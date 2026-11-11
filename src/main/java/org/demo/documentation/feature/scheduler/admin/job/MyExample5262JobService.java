package org.demo.documentation.feature.scheduler.admin.job;

import java.util.UUID;
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
public class MyExample5262JobService extends AnySourceVersionAwareResponseService<MyExample5262JobDTO, MyExample5262JobDTO> {

	private final MyExample5262JobDao jobDao;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5262JobMeta> meta = MyExample5262JobMeta.class;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5262JobDao> dao = MyExample5262JobDao.class;

	@Override
	protected CreateResult<MyExample5262JobDTO> doCreateEntity(MyExample5262JobDTO entity, BusinessComponent bc) {
		throw new IllegalStateException();
	}

	@Override
	protected ActionResultDTO<MyExample5262JobDTO> doUpdateEntity(MyExample5262JobDTO entity, MyExample5262JobDTO data,
			BusinessComponent bc) {
		throw new IllegalStateException();
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5262JobDTO> getActions() {
		return Actions.<MyExample5262JobDTO>builder()
				.action(act -> act
						.action("requeue", "Requeue")
						.invoker((bc, dto) -> {
							jobDao.requeue(UUID.fromString(bc.getId()));
							return new ActionResultDTO<MyExample5262JobDTO>()
									.setAction(PostAction.refreshBc(CxboxMyExample5262Controller.myexample5262jobstats));
						})
				)
				.action(act -> act
						.action("deleteJob", "Delete")
						.invoker((bc, dto) -> {
							jobDao.deleteJob(UUID.fromString(bc.getId()));
							return new ActionResultDTO<MyExample5262JobDTO>()
									.setAction(PostAction.refreshBc(CxboxMyExample5262Controller.myexample5262jobstats));
						})
				)
				.build();
	}
	// --8<-- [end:getActions]

}
