package org.demo.documentation.widgets.statsblock.showcondition.byparententity.parent;

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
public class MyExample4232Service extends VersionAwareResponseService<MyExample4232DTO, MyEntity4232> {

	private final MyEntity4232Repository repository;

	@Getter(onMethod_ = @Override)
	private final Class<MyExample4232Meta> meta = MyExample4232Meta.class;

	@Override
	protected CreateResult<MyExample4232DTO> doCreateEntity(MyEntity4232 entity, BusinessComponent bc) {
		repository.save(entity);
		return new CreateResult<>(entityToDto(bc, entity));
	}

	@Override
	protected ActionResultDTO<MyExample4232DTO> doUpdateEntity(MyEntity4232 entity, MyExample4232DTO data, BusinessComponent bc) {
		setIfChanged(data, MyExample4232DTO_.customFieldNumber, entity::setCustomFieldNumber);
		return new ActionResultDTO<>(entityToDto(bc, entity))
				.setAction(PostAction.refreshBc(bc));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyExample4232DTO> getActions() {
		return Actions.<MyExample4232DTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]

}
