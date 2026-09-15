package org.demo.documentation.widgets.calendarlist.title;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.dto.rowmeta.PostAction;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;

@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Service
public class MyExample5066Service extends VersionAwareResponseService<MyExample5066DTO, MyEntity5066> {

	private final MyEntity5066Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5066Meta> meta = MyExample5066Meta.class;

	@Override
	protected CreateResult<MyExample5066DTO> doCreateEntity(MyEntity5066 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5066DTO> doUpdateEntity(MyEntity5066 entity, MyExample5066DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5066DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5066DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5066DTO_.endDateTime, entity::setEndDateTime);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5066DTO> getActions() {
		return Actions.<MyExample5066DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
