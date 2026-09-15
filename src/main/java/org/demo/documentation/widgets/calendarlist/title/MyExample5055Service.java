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
public class MyExample5055Service extends VersionAwareResponseService<MyExample5055DTO, MyEntity5055> {

	private final MyEntity5055Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5055Meta> meta = MyExample5055Meta.class;

	@Override
	protected CreateResult<MyExample5055DTO> doCreateEntity(MyEntity5055 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5055DTO> doUpdateEntity(MyEntity5055 entity, MyExample5055DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5055DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5055DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5055DTO_.endDateTime, entity::setEndDateTime);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5055DTO> getActions() {
		return Actions.<MyExample5055DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
