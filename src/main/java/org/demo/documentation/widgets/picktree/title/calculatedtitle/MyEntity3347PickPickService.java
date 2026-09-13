package org.demo.documentation.widgets.picktree.title.calculatedtitle;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.cxbox.core.crudma.bc.BusinessComponent;
import org.cxbox.core.crudma.impl.VersionAwareResponseService;
import org.cxbox.core.dto.rowmeta.ActionResultDTO;
import org.cxbox.core.dto.rowmeta.CreateResult;
import org.cxbox.core.service.action.Actions;
import org.springframework.stereotype.Service;


@SuppressWarnings("java:S1170")
@RequiredArgsConstructor
@Getter
@Service
public class MyEntity3347PickPickService extends VersionAwareResponseService<MyEntity3347PickPickDTO, MyEntity3347Pick> {

	@Getter(onMethod_ = @Override)
	private final Class<MyEntity3347PickPickMeta> meta = MyEntity3347PickPickMeta.class;

	@Override
	protected CreateResult<MyEntity3347PickPickDTO> doCreateEntity(MyEntity3347Pick entity, BusinessComponent bc) {
		return null;
	}

	@Override
	protected ActionResultDTO<MyEntity3347PickPickDTO> doUpdateEntity(MyEntity3347Pick entity, MyEntity3347PickPickDTO data,
																	  BusinessComponent bc) {
		setIfChanged(data, MyEntity3347PickPickDTO_.customFieldPick, entity::setCustomFieldPick);
		return new ActionResultDTO<>(entityToDto(bc, entity));
	}

	// --8<-- [start:getActions]
	@Override
	public Actions<MyEntity3347PickPickDTO> getActions() {
		return Actions.<MyEntity3347PickPickDTO>builder()
				.save(sv -> sv.text("Save"))
				.build();
	}
	// --8<-- [end:getActions]
}