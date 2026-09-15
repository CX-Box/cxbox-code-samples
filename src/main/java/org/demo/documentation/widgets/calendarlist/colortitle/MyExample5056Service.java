package org.demo.documentation.widgets.calendarlist.colortitle;

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
public class MyExample5056Service extends VersionAwareResponseService<MyExample5056DTO, MyEntity5056> {

	private final MyEntity5056Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5056Meta> meta = MyExample5056Meta.class;

	@Override
	protected CreateResult<MyExample5056DTO> doCreateEntity(MyEntity5056 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5056DTO> doUpdateEntity(MyEntity5056 entity, MyExample5056DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5056DTO_.customField, entity::setCustomField);
		setIfChanged(data, MyExample5056DTO_.startDateTime, entity::setStartDateTime);
		setIfChanged(data, MyExample5056DTO_.endDateTime, entity::setEndDateTime);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5056DTO> getActions() {
		return Actions.<MyExample5056DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
