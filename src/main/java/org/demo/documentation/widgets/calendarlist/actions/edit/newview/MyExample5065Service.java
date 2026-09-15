package org.demo.documentation.widgets.calendarlist.actions.edit.newview;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.DrillDownType;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5065Service extends VersionAwareResponseService<MyExample5065DTO, MyEntity5065> {

	private final MyEntity5065Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5065Meta> meta = MyExample5065Meta.class;

	@Override
	protected CreateResult<MyExample5065DTO> doCreateEntity(MyEntity5065 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5065DTO> doUpdateEntity(MyEntity5065 entity, MyExample5065DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5065DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5065DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5065DTO_.endDateTime, entity::setEndDateTime);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5065DTO> getActions() {
		return Actions.<MyExample5065DTO>builder()
				.action(act -> act
						.action("finish", "Save and Close")
						.invoker((bc, dto) -> {
							MyEntity5065 myEntity = repository.getReferenceById(bc.getIdAsLong());
							repository.save(myEntity);
							return new ActionResultDTO<MyExample5065DTO>().setAction(
									PostAction.drillDown(
											DrillDownType.INNER,
											"/screen/myexample5065/view/myexample5065list"
									));
						})
				)
				.addGroup(
						"actions",
						"Actions",
						0,
						Actions.<MyExample5065DTO>builder()
								.action(act -> act
										.action("edit", "Edit")
										.withoutAutoSaveBefore()
										.invoker((bc, data) -> new ActionResultDTO<MyExample5065DTO>()
												.setAction(PostAction.drillDown(
														DrillDownType.INNER,
														"/screen/myexample5065/view/myexample5065form/"
																+ PlatformMyExample5065Controller.myexample5065 + "/"
																+ bc.getId()
												)))).build()
				)
				.build();
	}
	// --8<-- [end:getActions]

}
