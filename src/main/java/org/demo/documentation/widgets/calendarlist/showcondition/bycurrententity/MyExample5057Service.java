package org.demo.documentation.widgets.calendarlist.showcondition.bycurrententity;

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
public class MyExample5057Service extends VersionAwareResponseService<MyExample5057DTO, MyEntity5057> {

	private final MyEntity5057Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5057Meta> meta = MyExample5057Meta.class;

	@Override
	protected CreateResult<MyExample5057DTO> doCreateEntity(MyEntity5057 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5057DTO> doUpdateEntity(MyEntity5057 entity, MyExample5057DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5057DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5057DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5057DTO_.endDateTime, entity::setEndDateTime);
		setIfChanged(data, MyExample5057DTO_.customFieldNumber, entity::setCustomFieldNumber);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5057DTO> getActions() {
		return Actions.<MyExample5057DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
