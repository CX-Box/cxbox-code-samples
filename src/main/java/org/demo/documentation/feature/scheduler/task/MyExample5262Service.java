package org.demo.documentation.feature.scheduler.task;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.MessageType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.demo.documentation.feature.scheduler.CxboxMyExample5262Controller;
import org.jobrunr.scheduling.BackgroundJob;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5262Service extends VersionAwareResponseService<MyExample5262DTO, MyEntity5262> {

	private final MyEntity5262Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5262Meta> meta = MyExample5262Meta.class;

	@Override
	protected CreateResult<MyExample5262DTO> doCreateEntity(MyEntity5262 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5262DTO> doUpdateEntity(MyEntity5262 entity, MyExample5262DTO data,
			BusinessComponent bc) {
		if (data.isFieldChanged(MyExample5262DTO_.customField)) {
			entity.setCustomField(data.getCustomField());
		}
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	@Override
	public Actions<MyExample5262DTO> getActions() {
		return Actions.<MyExample5262DTO>builder()
				.create(crt -> crt.text("Add"))
				.save(sv -> sv.text("Save"))
				// --8<-- [start:enqueue]
				.action(act -> act
						.action("runNow", "Run now in background")
						.invoker((bc, data) -> {
							Long id = bc.getIdAsLong();
							repository.getReferenceById(id)
									.setStatus(MyEntity5262Status.ENQUEUED)
									.setScheduledDate(LocalDateTime.now());
							BackgroundJob.<MyExample5262JobHandler>enqueue(x -> x.execute(id));
							return new ActionResultDTO<MyExample5262DTO>()
									.setAction(PostAction.refreshBc(CxboxMyExample5262Controller.myexample5262));
						})
				)
				// --8<-- [end:enqueue]
				// --8<-- [start:schedule]
				.action(act -> act
						.action("runInOneMinute", "Run in 1 minute")
						.invoker((bc, data) -> {
							Long id = bc.getIdAsLong();
							LocalDateTime runAt = LocalDateTime.now().plusMinutes(1);
							repository.getReferenceById(id)
									.setStatus(MyEntity5262Status.SCHEDULED)
									.setScheduledDate(runAt);
							BackgroundJob.<MyExample5262JobHandler>schedule(runAt, x -> x.execute(id));
							return new ActionResultDTO<MyExample5262DTO>()
									.setAction(PostAction.showMessage(MessageType.INFO, "The job will run in 1 minute."));
						})
				)
				// --8<-- [end:schedule]
				.build();
	}

}
