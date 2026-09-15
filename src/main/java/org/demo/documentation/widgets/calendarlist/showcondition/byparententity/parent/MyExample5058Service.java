package org.demo.documentation.widgets.calendarlist.showcondition.byparententity.parent;

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
public class MyExample5058Service extends VersionAwareResponseService<MyExample5058DTO, MyEntity5058> {

	private final MyEntity5058Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample5058Meta> meta = MyExample5058Meta.class;

	@Override
	protected CreateResult<MyExample5058DTO> doCreateEntity(MyEntity5058 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample5058DTO> doUpdateEntity(MyEntity5058 entity, MyExample5058DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample5058DTO_.customFieldNumber, entity::setCustomFieldNumber);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample5058DTO> getActions() {
		return Actions.<MyExample5058DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
